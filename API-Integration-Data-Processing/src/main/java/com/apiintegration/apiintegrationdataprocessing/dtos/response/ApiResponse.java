package com.apiintegration.apiintegrationdataprocessing.dtos.response;

import com.apiintegration.apiintegrationdataprocessing.model.ApiResponseStatus;
import lombok.Data;

@Data
public class ApiResponse<T> {
    private String status;
    private T data;

    public ApiResponse(ApiResponseStatus status, T data) {
        this.status = status.toString().toLowerCase();
        this.data = data;
    }
}
