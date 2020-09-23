package com.eportfolio2077.eportfolio.controller;

import com.eportfolio2077.eportfolio.common.ResponseBody;
import com.eportfolio2077.eportfolio.dto.BlogDto;
import com.eportfolio2077.eportfolio.service.AWSS3Service;
import com.eportfolio2077.eportfolio.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    SiteService siteService;
    @Autowired
    AWSS3Service awss3Service;


    @RequestMapping("/upload/img")
    public ResponseEntity<ResponseBody> uploadImage(@RequestParam("file") MultipartFile image, @RequestParam("siteId") Long siteId){
        String imagePath;
        try {
            imagePath = awss3Service.uploadFile(image);
            siteService.updateImg(imagePath, siteId);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(imagePath));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.uploadFail());
        }
    }

    @RequestMapping("/update/blog")
    public ResponseEntity<ResponseBody> updateBlog(@RequestBody BlogDto blogDto){
        try{
            siteService.updateBlog(blogDto);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.uploadFail());
        }
    }

    @DeleteMapping("/delete")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return awss3Service.deleteFileFromS3Bucket(fileUrl);
    }
}
