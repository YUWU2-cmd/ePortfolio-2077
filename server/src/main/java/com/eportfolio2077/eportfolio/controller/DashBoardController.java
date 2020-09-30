package com.eportfolio2077.eportfolio.controller;

import com.eportfolio2077.eportfolio.common.ResponseBody;
import com.eportfolio2077.eportfolio.entity.Site;
import com.eportfolio2077.eportfolio.service.DashBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashBoardController {

    @Autowired
    DashBoardService dashBoardService;

    @RequestMapping("/create")
    public ResponseEntity<ResponseBody> createSite(@CookieValue(value = "userId", defaultValue = "none") Long userId, @RequestParam("template")String template){
        Site site = dashBoardService.createSite(userId, template);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(site));
    }

    @RequestMapping("/load")
    public ResponseEntity<ResponseBody> load(@CookieValue(value = "userId", defaultValue = "none") Long userId){
        List<Site> sites = dashBoardService.fetchAllSitePage(userId);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(sites));
    }

    @RequestMapping("/fetch")
    public ResponseEntity<ResponseBody> fetch(@CookieValue(value = "userId", defaultValue = "none") Long userId, @RequestParam("siteId") Long siteId){
        Site site = dashBoardService.fetchSitePage(userId,siteId);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success(site));
    }

    @RequestMapping("/delete")
    public ResponseEntity<ResponseBody> delete(@CookieValue(value = "userId", defaultValue = "none") Long userId, @RequestParam("siteId") Long siteId){
        dashBoardService.deleteSite(userId, siteId);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseBody.success());
    }

}
