package com.apiintegration.apiintegrationdataprocessing.service;

import com.apiintegration.apiintegrationdataprocessing.dtos.request.ApiRequest;
import com.apiintegration.apiintegrationdataprocessing.dtos.response.GenderResponse;
import com.apiintegration.apiintegrationdataprocessing.exception.NullGenderNameOrCountException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ApiIntegrationServiceTest {
    @Autowired
    private ApiIntegrationService apiIntegrationService;



    @Test
    void testThatApiIntegrationServiceReturnsSuccess(){
        String name ="adedotun";
        GenderResponse apiResponse = apiIntegrationService.genderize(name);
        assertNotNull(apiResponse);
        assertEquals("male",apiResponse.getGender());
        assertTrue(apiResponse.getIs_confident());
    }

    @Test
    void testThatApiIntegrationServiceReturnsErrorIfRequestIsHasNoPrediction(){
        String name ="adedotun";
        assertThrows(NullGenderNameOrCountException.class,()->apiIntegrationService.genderize(name));
    }

}