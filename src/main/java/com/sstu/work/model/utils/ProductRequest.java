package com.sstu.work.model.utils;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductRequest {
    String name;
    String description;
    String price;
    String categoryId;
    String countryId;
    MultipartFile image;
}
