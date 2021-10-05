package com.sstu.work.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class User {
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private List<Role> roles;
    private Date birthday;
}
