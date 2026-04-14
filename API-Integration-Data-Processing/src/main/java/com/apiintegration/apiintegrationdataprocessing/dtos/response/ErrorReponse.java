package com.apiintegration.apiintegrationdataprocessing.dtos.response;

import lombok.Data;

@Data
public class ErrorReponse<T> {
    private String status;
    private T message;

    public  ErrorReponse(String status, T message) {
        this.status = status;
        this.message = message;
    }

}
