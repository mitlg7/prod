package com.sstu.work.model.utils;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String email;
    private String login;
    private String password;
}
