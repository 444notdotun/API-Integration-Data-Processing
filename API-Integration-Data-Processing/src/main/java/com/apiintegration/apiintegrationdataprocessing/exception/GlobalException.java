package com.apiintegration.apiintegrationdataprocessing.exception;

import com.apiintegration.apiintegrationdataprocessing.dtos.response.ApiResponse;
import com.apiintegration.apiintegrationdataprocessing.model.ApiResponseStatus;
import jakarta.validation.ConstraintViolationException;
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
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new ApiResponse<>(ApiResponseStatus.ERROR, e.getMessage()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<String>> handleMethodArgumentNotValidException(ConstraintViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(ApiResponseStatus.ERROR, e.getMessage()));
    }
    @ExceptionHandler(InvalidUrlCallException.class)
    public ResponseEntity<ApiResponse<String>> handleInvalidUrlCallException(InvalidUrlCallException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(ApiResponseStatus.ERROR, e.getMessage()));
    }

    @ExceptionHandler(NullGenderNameOrCountException.class)
    public ResponseEntity<ApiResponse<String>> handleNullGenderNameOrCountException(NullGenderNameOrCountException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(ApiResponseStatus.ERROR, e.getMessage()));
    }

    @ExceptionHandler(UnprocessableNameException.class)
    public ResponseEntity<ApiResponse<String>> handleUnprocessableNameException(UnprocessableNameException e) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ApiResponse<>(ApiResponseStatus.ERROR, e.getMessage()));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(ApiResponseStatus.ERROR, e.getMessage()));
    }
}
