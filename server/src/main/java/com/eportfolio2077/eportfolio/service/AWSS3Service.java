package com.eportfolio2077.eportfolio.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.eportfolio2077.eportfolio.dao.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

import javax.transaction.Transactional;

@Service
public class AWSS3Service {

    @Autowired
    AmazonS3 amazonS3;
    @Autowired
    ImageDao imageDao;
    @Value("${aws.s3.bucket}")
    private String bucketName;
    @Value("${aws.endpoint_url}")
    private String endpointUrl;

    @Transactional
    public String uploadFile(MultipartFile multipartFile) throws AmazonServiceException, IOException {
        String fileUrl = "";
        File file = convertMultiPartFileToFile(multipartFile);
        String fileName = generateFileName(multipartFile);
        fileUrl = endpointUrl + "/" + fileName;
        uploadFileTos3bucket(fileName, file);
        file.delete();
        return fileUrl;
    }

    private File convertMultiPartFileToFile(MultipartFile multipartFile) throws IOException {
        File convFile = new File(multipartFile.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipartFile.getBytes());
        fos.close();
        return convFile;
    }


    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }

    private void uploadFileTos3bucket(String fileName, File file) {
        amazonS3.putObject(new PutObjectRequest(bucketName, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }

    public String deleteFileFromS3Bucket(String fileUrl) {
        //TODO a lot: update with db?
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        amazonS3.deleteObject(new DeleteObjectRequest(bucketName + "/", fileName));
        return "Successfully deleted";
    }
}
