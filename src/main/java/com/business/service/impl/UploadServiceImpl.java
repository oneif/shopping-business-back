package com.business.service.impl;

import com.business.pojo.Upload;
import com.business.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    Upload upload;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        if (!upload.getAllowTypes().contains(file.getContentType())) {
            throw new IOException("文件上传类型错误！");
        }
        String fileName = file.getOriginalFilename();
        File newFile = new File(upload.getPath() + fileName);
        file.transferTo(newFile);
        return fileName;
    }
}
