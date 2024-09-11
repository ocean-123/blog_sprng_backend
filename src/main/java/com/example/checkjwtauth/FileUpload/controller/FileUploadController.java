package com.example.checkjwtauth.FileUpload.controller;


import com.example.checkjwtauth.FileUpload.Constants;
import com.example.checkjwtauth.FileUpload.utils.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/a")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FileUploadController {

    @Autowired
    FileUploadHelper fileUploadHelper;

    @RequestMapping(value = "images/save", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveImage(@RequestParam("file") MultipartFile files) throws IOException {

//        files.transferTo(new File("abc/abc"));
        System.out.println(" File Size : " + files.getSize());
        String imageName = "";
        try {
            imageName = fileUploadHelper.uploadImage(files);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(imageName);
    }

    @RequestMapping(value = "/images/savelist", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveImageList(@RequestParam("file") List<MultipartFile> files) {
        //System.out.println(" File Size : " + files.getSize());
        List<String> imageName = new ArrayList<>();
        try {
            List<String> list = new ArrayList<>();
            FileUploadHelper fileUploadHelper1 = fileUploadHelper;
            for (MultipartFile file : files) {
                String s = fileUploadHelper1.uploadImage(file);
                list.add(s);
            }
            imageName = list;//fileUploadHelper.uploadImage(files);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(imageName);
    }

    @GetMapping(value = "images/{fileName}.{ext}"/*, produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.APPLICATION_PDF_VALUE}*/, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody
    ResponseEntity<ByteArrayResource> getImage(@PathVariable("fileName") String fileName,
                                               @PathVariable("ext") String ext) throws IOException {
//        InputStream in = new FileInputStream(
        InputStream in = new FileInputStream(new File(Constants.realPath+File.separator+fileName+"."+ext));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len;
        byte[] buffer = new byte[4096];
        while ((len = in.read(buffer, 0, buffer.length)) != -1) {
            baos.write(buffer, 0, len);
        }
        byte[] bytes = baos.toByteArray();
        ByteArrayResource resource = new ByteArrayResource(bytes);
        return ResponseEntity.ok().body(resource);
        //return IOUtils.toByteArray(in);
    }


//    @GetMapping(value = "images/pdf/{dir}/{fileName}.{ext}", produces = {MediaType.APPLICATION_PDF_VALUE})
//    public @ResponseBody
//    byte[] getPdf(@PathVariable("dir") String dir, @PathVariable("fileName") String fileName,
//                  @PathVariable("ext") String ext) throws IOException {
//        InputStream in = Files.newInputStream(new File(Constants.realPath + File.separator + fileName + "." + ext).toPath());
//        return IOUtils.toByteArray(in);
//    }
}
