package com.sstu.work.service.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    @Value("${upload.path}")
    private String uploadPath;

    public String saveImage(MultipartFile file) {
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String resultFileName = UUID.randomUUID().toString().substring(1,32) + file.getOriginalFilename();
        try {
            file.transferTo(new File(uploadPath + "/" + resultFileName));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultFileName;
    }
}
