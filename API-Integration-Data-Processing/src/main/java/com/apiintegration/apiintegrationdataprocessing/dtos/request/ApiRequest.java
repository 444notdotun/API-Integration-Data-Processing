package com.apiintegration.apiintegrationdataprocessing.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ApiRequest {
    @NotBlank(message = "Name is required")
    private String name;
}
