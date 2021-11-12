package com.sstu.work.service.utils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;


public interface ImageService {

    public String saveImage(MultipartFile file);
}
