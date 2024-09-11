package com.example.checkjwtauth.thirdapi.service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ThirdPartyService {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public String callThirdPartyApi() throws IOException {
        HttpGet request = new HttpGet("https://api.example.com/data");
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            return EntityUtils.toString(response.getEntity());
        }
    }
}