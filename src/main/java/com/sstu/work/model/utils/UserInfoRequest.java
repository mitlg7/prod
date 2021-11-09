package com.sstu.work.model.utils;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class UserInfoRequest {
    String name;
    String lastname;
    Date birthday;
    String phone;
    MultipartFile image;
}
