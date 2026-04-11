package com.apiintegration.apiintegrationdataprocessing.exception;

import com.apiintegration.apiintegrationdataprocessing.dtos.response.ApiResponse;
import com.apiintegration.apiintegrationdataprocessing.model.ApiResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ApiCallException.class)
    public ResponseEntity<ApiResponse<String>> handleApiCallException(ApiCallException e) {
        return ResponseEntity.status(HttpStatusCode.valueOf(429)).body(new ApiResponse<>(ApiResponseStatus.ERROR, e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ApiResponse<>(ApiResponseStatus.ERROR, e.getMessage()));
    }
    @ExceptionHandler(InvalidUrlCallException.class)
    public ResponseEntity<ApiResponse<String>> handleInvalidUrlCallException(InvalidUrlCallException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(ApiResponseStatus.ERROR, e.getMessage()));
    }

    @ExceptionHandler(NullGenderNameOrCountException.class)
    public ResponseEntity<ApiResponse<String>> handleNullGenderNameOrCountException(NullGenderNameOrCountException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(ApiResponseStatus.ERROR, e.getMessage()));
    }
}
