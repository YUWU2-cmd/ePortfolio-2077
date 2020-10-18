package com.eportfolio2077.eportfolio.controller;

import com.eportfolio2077.eportfolio.common.ResponseBody;
import com.eportfolio2077.eportfolio.dto.*;
import com.eportfolio2077.eportfolio.entity.Image;
import com.eportfolio2077.eportfolio.service.AWSS3Service;
import com.eportfolio2077.eportfolio.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


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

    @RequestMapping("/update/classic/aboutme")
    public ResponseEntity<ResponseBody> updateAboutMe(@RequestParam("bio") String bio, @RequestParam("aboutme") String aboutMe, @RequestParam("siteId") Long siteId){
        try{
            siteService.updateAboutMe(bio, aboutMe, siteId);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.uploadFail());
        }
    }

    @RequestMapping("/update/classic/experience")
    public ResponseEntity<ResponseBody> updateExperience(@RequestBody ExperienceWrapper experienceWrapper){
        try{
            siteService.updateExperience(experienceWrapper);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success());
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.uploadFail());
        }
    }

    @RequestMapping("/update/classic/education")
    public ResponseEntity<ResponseBody> updateEducation(@RequestBody EducationWrapper educationWrapper){
        try{
            siteService.updateEducation(educationWrapper);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.uploadFail());
        }
    }

    @RequestMapping("/update/classic/skill")
    public ResponseEntity<ResponseBody> updateSkill(@RequestBody UserSkillWrapper userSkillWrapper){
        try{
            siteService.updateSkill(userSkillWrapper);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.uploadFail());
        }
    }

    @RequestMapping("/update/classic/project")
    public ResponseEntity<ResponseBody> updateProject(@RequestBody ProjectWrapper projectWrapper){
        try{
            siteService.updateProject(projectWrapper);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success());
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.uploadFail());
        }
    }

    @RequestMapping("/get/classic/experience")
    public ResponseEntity<ResponseBody> getExperience(@RequestParam("siteId") Long siteId){
        try{
            ExperienceWrapper ew = siteService.getExperience(siteId);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(ew));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.serverError());
        }
    }

    @RequestMapping("/get/classic/skill")
    public ResponseEntity<ResponseBody> getSkill(@RequestParam("siteId") Long siteId){
        try{
            UserSkillDto usd = siteService.getSkill(siteId);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(usd));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.serverError());
        }
    }

    @RequestMapping("/get/classic/education")
    public ResponseEntity<ResponseBody> getEducation(@RequestParam("siteId") Long siteId){
        try{
            EducationWrapper ew = siteService.getEducation(siteId);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(ew));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.serverError());
        }
    }

    @RequestMapping("/get/classic/project")
    public ResponseEntity<ResponseBody> getProject(@RequestParam("siteId") Long siteId){
        try{
            ProjectWrapper pw = siteService.getProject(siteId);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(pw));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.serverError());
        }
    }

    @RequestMapping("/get/img")
    public ResponseEntity<ResponseBody> getImg(@RequestParam("siteId") Long siteId){
        try{
            List<Image> imageList= siteService.getImg(siteId);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(imageList));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.serverError());
        }
    }

    @RequestMapping("/get/gallery/aboutpic")
    public ResponseEntity<ResponseBody> getAboutMePic(@RequestParam("siteId") Long siteId){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(siteService.getAboutMePic(siteId)));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.serverError());
        }
    }

    @RequestMapping("/update/gallery/aboutpic")
    public ResponseEntity<ResponseBody> updateAboutMePic(@RequestParam("file") MultipartFile image, @RequestParam("siteId") Long siteId){
        String imagePath;
        try {
            imagePath = awss3Service.uploadFile(image);
            siteService.updateAboutMePic(imagePath, siteId);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(imagePath));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.uploadFail());
        }
    }

    @RequestMapping("/get/business/skill")
    public ResponseEntity<ResponseBody> getSkillBusiness(@RequestParam("siteId") Long siteId){
        try{
            UserSkillDtoBusiness usdb = siteService.getSkillBusiness(siteId);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(usdb));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.serverError());
        }
    }

    @RequestMapping("/update/business/skill")
    public ResponseEntity<ResponseBody> updateSkillBusiness(@RequestBody UserSkillWrapperBusiness userSkillWrapperBusiness){
        try{
            siteService.updateSkillBusiness(userSkillWrapperBusiness);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.uploadFail());
        }
    }

    @RequestMapping("/get/business/education")
    public ResponseEntity<ResponseBody> getEducationBusiness(@RequestParam("siteId") Long siteId){
        try{
            EducationWrapperBusiness ew = siteService.getEducationBusiness(siteId);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(ew));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.serverError());
        }
    }

    @RequestMapping("/update/business/education")
    public ResponseEntity<ResponseBody> updateEducationBusiness(@RequestBody EducationWrapperBusiness educationWrapper){
        try{
            siteService.updateEducationBusiness(educationWrapper);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBody.uploadFail());
        }
    }

}
