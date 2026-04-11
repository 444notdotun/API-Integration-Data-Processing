package com.apiintegration.apiintegrationdataprocessing.service;

import com.apiintegration.apiintegrationdataprocessing.dtos.request.ApiRequest;
import com.apiintegration.apiintegrationdataprocessing.dtos.response.GenderResponse;

public interface ApiIntegrationService {
    GenderResponse genderize(String name);
}
