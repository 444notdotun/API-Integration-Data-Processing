package com.apiintegration.apiintegrationdataprocessing.model;

import lombok.Data;

@Data
public class Gender {
    private String name;
    private String gender;
    private Double probability;
    private Integer count;
}
