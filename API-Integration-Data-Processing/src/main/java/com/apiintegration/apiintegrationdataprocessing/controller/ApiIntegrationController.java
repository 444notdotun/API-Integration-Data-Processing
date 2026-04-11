package com.apiintegration.apiintegrationdataprocessing.controller;

import com.apiintegration.apiintegrationdataprocessing.dtos.request.ApiRequest;
import com.apiintegration.apiintegrationdataprocessing.dtos.response.ApiResponse;
import com.apiintegration.apiintegrationdataprocessing.dtos.response.GenderResponse;
import com.apiintegration.apiintegrationdataprocessing.model.ApiResponseStatus;
import com.apiintegration.apiintegrationdataprocessing.service.ApiIntegrationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
@Validated
public class ApiIntegrationController {
    @Autowired
    private ApiIntegrationService apiIntegrationService;

    @GetMapping("/classify")
    public ResponseEntity<ApiResponse<GenderResponse>>  genderize(@NotBlank(message = "Missing or empty name parameter")  @RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(ApiResponseStatus.SUCCESS,apiIntegrationService.genderize(name)));
    }
}
