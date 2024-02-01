package com.business.pojo;

import lombok.Data;

@Data
public class Products {
    private Long id;
    private String name;
    private String img;
    private String description;
    private String price;
    private String unit;
    private String type;
    private String typeId;
    private String businessId;
    private String count;
}
