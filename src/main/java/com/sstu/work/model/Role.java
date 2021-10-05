package com.sstu.work.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Role {
    ADMIN("Администратор"),
    USER("Пользователь"),
    PRODUCER("Поставщик");
    String role;
    Role(String role){
        this.role = role;
    }

}
