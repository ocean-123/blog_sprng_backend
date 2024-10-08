package com.example.checkjwtauth.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    public static final String JWT_SECRET =   "gwdvlkartxfxbrmnlsnqerfbhlafxehhjvusxmeztpupekwmhdcgynywcwnfpmzqiegfocdntsvkwjczthapeujwuyjqrjsbuujupighttpyavwdaznoxcowkxhfgvtvjzejvgqpfnikowrrgqmwgbhdtmyboodoqxizrhkftheeoepdccubrsfhlixqhbnhgyjmnobaoeafvrxrjoyvetuiqnusqpqflgsnuvlcjpuoagicmjmjcwrjxzhegpji";

    public String extractUserName(String token) {

        return extractClaim(token,Claims::getSubject);
    }

    public <T> T extractClaim(String token , Function<Claims,T> claimsTFunction){
        final  Claims claims = extractALlClaims(token);
        return claimsTFunction.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public  String generateToken(Map<String,Object>extractClaims , UserDetails userDetails){

        return Jwts
                .builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24*2))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    public Boolean validate(String token,UserDetails userDetails){

        final  String username = extractUserName(token);
        return (username.equals(userDetails.getUsername()))&& !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {

        return extractExpiration(token).before(new Date());

    }

    private Date extractExpiration(String token) {
        return  extractClaim(token,Claims::getExpiration);
    }

    public Claims extractALlClaims(String token) {

        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(JWT_SECRET);

        return Keys.hmacShaKeyFor(keyBytes);
    }
}
