package com.sstu.work.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private Long Id;
    private String login;
    private String email;
    private String password;
    private Role role;
    private UserInfo info;

}
