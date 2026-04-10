package com.apiintegration.apiintegrationdataprocessing.service;

import com.apiintegration.apiintegrationdataprocessing.dtos.request.ApiRequest;
import com.apiintegration.apiintegrationdataprocessing.dtos.response.ApiResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiIntegrationServiceTest {



    @Test
    void testThatApiIntegrationServiceReturnsSuccess(){
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.setName("adedotun");
        ApiResponse apiResponse = ApiIntegrationService.genderize(apiRequest);
    }

}