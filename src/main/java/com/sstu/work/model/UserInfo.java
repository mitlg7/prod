package com.sstu.work.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class UserInfo {
    private Long id;
    private String name;
    private String lastName;
    private String phone;
    private Date birthday;
    private String image;
}
