package com.sstu.work.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Category {
    private Long id;
    private String type;
}
