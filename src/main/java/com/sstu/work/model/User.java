package com.sstu.work.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class User {
    private Long Id;
    private String login;
    private String email;
    private String password;
    private List<Role> roles;

}
