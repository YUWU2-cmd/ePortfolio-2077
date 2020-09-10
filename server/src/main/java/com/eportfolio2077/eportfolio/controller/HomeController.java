package com.eportfolio2077.eportfolio.controller;

import com.amazonaws.AmazonServiceException;
import com.eportfolio2077.eportfolio.common.ResponseBody;
import com.eportfolio2077.eportfolio.service.AWSS3Service;
import com.eportfolio2077.eportfolio.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    HomeService homeService;

    @Autowired
    AWSS3Service awss3Service;


    @RequestMapping("/upload/img")
    public ResponseEntity<ResponseBody> uploadImage(@RequestParam("file") MultipartFile image){
        String imagePath;
        try {
            imagePath = awss3Service.uploadFile(image);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.uploadFail());
        }

        return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(imagePath));
    }

    @DeleteMapping("/delete")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return awss3Service.deleteFileFromS3Bucket(fileUrl);
    }

//    @RequestMapping("/update/blog")
//    public ResponseEntity<ResponseBody> updateBlog(@RequestBody String blog){
//        homeService.
//    }
}
