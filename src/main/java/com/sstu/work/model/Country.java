package com.sstu.work.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Country {
    private Long id;
    private String name;
}
