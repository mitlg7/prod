package com.sstu.work.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Long userId;
    private String name;
    private String lastName;
    private String phone;
    private Date birthday;
    private String image;
}
