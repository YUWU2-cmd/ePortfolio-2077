package com.eportfolio2077.eportfolio.service;

import com.eportfolio2077.eportfolio.dao.*;
import com.eportfolio2077.eportfolio.dto.*;
import com.eportfolio2077.eportfolio.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class SiteService {
    @Autowired
    SiteDao siteDao;
    @Autowired
    ImageDao imageDao;
    @Autowired
    UserDao userDao;
    @Autowired
    ExperienceDao experienceDao;
    @Autowired
    EducationDao educationDao;
    @Autowired
    UserSkillDao userSkillDao;
    @Autowired
    ProjectDao projectDao;
    @Autowired
    ProjectSeriesDao projectSeriesDao;


    public void updateImg(String imagePath, Long siteId){
        Image image = new Image(imagePath);
        image.setSiteId(siteId);
        imageDao.save(image);
    }

    public void updateAboutMePic(String imagePath, Long siteId){
        Site site = siteDao.getSiteBySiteId(siteId);
        site.setAboutMePic(imagePath);
        siteDao.save(site);
    }

    public void updateAboutMe(String bio, String aboutMe, Long siteId){
        Site site = siteDao.getSiteBySiteId(siteId);
        site.setAboutMe(aboutMe);
        site.setBio(bio);
        siteDao.save(site);
    }

    @Transactional
    public void updateExperience(ExperienceWrapper experienceWrapper){
        Long siteId = experienceWrapper.getSiteId();
        experienceDao.deleteAllBySiteId(siteId);
        for(Experience e:experienceWrapper.getExperiences()){
            e.setSiteId(siteId);
            experienceDao.save(e);
        }
    }

    @Transactional
    public void updateEducation(EducationWrapper educationWrapper){
        Long siteId = educationWrapper.getSiteId();
        educationDao.deleteAllBySiteIdAndBusiness(siteId, "False");
        for(Education e:educationWrapper.getEducations()){
            e.setSiteId(siteId);
            e.setBusiness("False");
            educationDao.save(e);
        }
    }

    @Transactional
    public void updateEducationBusiness(EducationWrapperBusiness educationWrapperBusiness){
        Long siteId = educationWrapperBusiness.getSiteId();
        educationDao.deleteEducationBySiteIdAndBusiness(siteId, "True");
        Education e = educationWrapperBusiness.getEducation();
        e.setSiteId(siteId);
        e.setBusiness("True");
        educationDao.save(e);
    }

    @Transactional
    public void updateSkill(UserSkillWrapper userSkillWrapper){
        Long siteId = userSkillWrapper.getSiteId();
        userSkillDao.deleteAllBySiteId(siteId);
        for(String s:userSkillWrapper.getProList()){
            UserSkill us = new UserSkill();
            us.setSkillType("Professional");
            us.setSkillName(s);
            us.setSiteId(siteId);
            userSkillDao.save(us);
        }

        for(String s:userSkillWrapper.getAddList()){
            UserSkill us = new UserSkill();
            us.setSkillType("Additional");
            us.setSkillName(s);
            us.setSiteId(siteId);
            userSkillDao.save(us);
        }
    }

    @Transactional
    public void updateSkillBusiness(UserSkillWrapperBusiness userSkillWrapperBusiness){
        Long siteId = userSkillWrapperBusiness.getSiteId();
        userSkillDao.deleteAllBySiteId(siteId);
        for(int i = 0; i < userSkillWrapperBusiness.getSkillList().size(); i++){
            String s = userSkillWrapperBusiness.getSkillList().get(i);
            int score = userSkillWrapperBusiness.getSkillScore().get(i).intValue();
            UserSkill us = new UserSkill();
            us.setSkillType("Skill");
            us.setSkillName(s);
            us.setScore(score);
            us.setSiteId(siteId);
            userSkillDao.save(us);
        }

        for(int i = 0; i < userSkillWrapperBusiness.getLanguageList().size(); i++){
            String s = userSkillWrapperBusiness.getLanguageList().get(i);
            int score = userSkillWrapperBusiness.getLanguageScore().get(i).intValue();
            UserSkill us = new UserSkill();
            us.setSkillType("Language");
            us.setSkillName(s);
            us.setScore(score);
            us.setSiteId(siteId);
            userSkillDao.save(us);
        }

        for(String s:userSkillWrapperBusiness.getAwardList()){
            UserSkill us = new UserSkill();
            us.setSkillType("Award");
            us.setSkillName(s);
            us.setSiteId(siteId);
            userSkillDao.save(us);
        }

        for(String s:userSkillWrapperBusiness.getInterestList()){
            UserSkill us = new UserSkill();
            us.setSkillType("Interest");
            us.setSkillName(s);
            us.setSiteId(siteId);
            userSkillDao.save(us);
        }
    }

    @Transactional
    public void updateProject(ProjectWrapper projectWrapper){
        Long siteId = projectWrapper.getSiteId();
        ProjectSeries projectSeries = projectSeriesDao.getBySiteId(siteId);
        if(projectSeries==null){
            projectSeries = new ProjectSeries();
        }else{
            projectDao.deleteAllByProjectSeriesId(projectSeries.getProjectSeriesId());
        }

        projectSeries.setSiteId(siteId);
        projectSeries.setSeriesName(projectWrapper.getSeriesName());
        projectSeries.setSummary(projectWrapper.getSummary());
        projectSeriesDao.save(projectSeries);

        for(Project p:projectWrapper.getProjects()){
            p.setProjectSeriesId(projectSeries.getProjectSeriesId());
            projectDao.save(p);
        }
    }

    public ExperienceWrapper getExperience(Long siteId){
        ExperienceWrapper ew = new ExperienceWrapper();
        ew.setExperiences(experienceDao.getAllBySiteId(siteId));
        ew.setSiteId(siteId);
        return ew;
    }

    public EducationWrapper getEducation(Long siteId){
        EducationWrapper ew = new EducationWrapper();
        ew.setEducations(educationDao.getAllBySiteIdAndBusiness(siteId, "False"));
        ew.setSiteId(siteId);
        return ew;
    }

    public EducationWrapperBusiness getEducationBusiness(Long siteId){
        EducationWrapperBusiness ew = new EducationWrapperBusiness();
        ew.setEducation(educationDao.getEducationBySiteIdAndBusiness(siteId, "True"));
        ew.setSiteId(siteId);
        return ew;
    }

    public UserSkillDto getSkill(Long siteId){
        UserSkillDto userSkillDto = new UserSkillDto();
        userSkillDto.setProList(userSkillDao.getAllBySiteIdAndSkillType(siteId, "Professional"));
        userSkillDto.setAddList(userSkillDao.getAllBySiteIdAndSkillType(siteId, "Additional"));
        return userSkillDto;
    }

    public UserSkillDtoBusiness getSkillBusiness(Long siteId){
        UserSkillDtoBusiness userSkillDtoBusiness = new UserSkillDtoBusiness();
        userSkillDtoBusiness.setSkillList(userSkillDao.getAllBySiteIdAndSkillType(siteId, "Skill"));
        userSkillDtoBusiness.setLanguageList(userSkillDao.getAllBySiteIdAndSkillType(siteId, "Language"));
        userSkillDtoBusiness.setAwardList(userSkillDao.getAllBySiteIdAndSkillType(siteId, "Award"));
        userSkillDtoBusiness.setInterestList(userSkillDao.getAllBySiteIdAndSkillType(siteId, "Interest"));
        return userSkillDtoBusiness;
    }

    public ProjectWrapper getProject(Long siteId){
        ProjectWrapper pw = new ProjectWrapper();
        ProjectSeries ps = projectSeriesDao.getBySiteId(siteId);
        pw.setSeriesName(ps.getSeriesName());
        pw.setSummary(ps.getSummary());
        pw.setProjects(projectDao.getAllByProjectSeriesId(ps.getProjectSeriesId()));
        pw.setSiteId(siteId);
        return pw;
    }

    public List<Image> getImg(Long siteId){
        return imageDao.getAllBySiteId(siteId);
    }

    public String getAboutMePic(Long siteId) {
        return siteDao.getSiteBySiteId(siteId).getAboutMePic();
    }

    @Transactional
    public void deleteRelated(Long siteId){
        imageDao.deleteAllBySiteId(siteId);
        userSkillDao.deleteAllBySiteId(siteId);
        experienceDao.deleteAllBySiteId(siteId);
        educationDao.deleteAllBySiteId(siteId);
        ProjectSeries ps = projectSeriesDao.getBySiteId(siteId);
        if(ps!=null){
            projectDao.deleteAllByProjectSeriesId(ps.getProjectSeriesId());
        }
        projectSeriesDao.deleteAllBySiteId(siteId);
    }

    public void visitOnce(Long siteId){
        Site site = siteDao.getSiteBySiteId(siteId);
        if(site.getVisit()==null){
            site.setVisit(0);
        }
        site.setVisit(site.getVisit()+1);
        siteDao.save(site);
    }
}