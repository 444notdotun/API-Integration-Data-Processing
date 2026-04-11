package com.apiintegration.apiintegrationdataprocessing.exception;

public class InvalidUrlCallException extends ApiIntegrationException {
    public InvalidUrlCallException(String invalidUrl) {
        super(invalidUrl);
    }
}
