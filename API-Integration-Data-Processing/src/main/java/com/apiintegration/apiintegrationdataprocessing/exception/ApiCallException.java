package com.apiintegration.apiintegrationdataprocessing.exception;

public class ApiCallException extends ApiIntegrationException {
    public ApiCallException(String apiCallReturnError) {
        super(apiCallReturnError);
    }
}
