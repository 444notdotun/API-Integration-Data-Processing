package com.apiintegration.apiintegrationdataprocessing.dtos.response;

import com.apiintegration.apiintegrationdataprocessing.model.ApiResponseStatus;
import lombok.Data;

@Data
public class ApiResponse<T> {
    private ApiResponseStatus status;
    private T data;

    public ApiResponse(ApiResponseStatus status, T data) {
        this.status = status;
        this.data = data;
    }
}
