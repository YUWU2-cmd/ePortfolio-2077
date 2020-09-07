package com.eportfolio2077.eportfolio.service;

import com.eportfolio2077.eportfolio.dao.FileDao;
import com.eportfolio2077.eportfolio.entity.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {
    @Autowired
    FileDao fileDao;

    public File uploadFile(MultipartFile file) throws IOException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        File newFile = new File(filename, file.getContentType(), file.getBytes());
        return fileDao.save(newFile);
    }

    public File getFile(String id){
        return fileDao.findById(id).get();
    }

}
