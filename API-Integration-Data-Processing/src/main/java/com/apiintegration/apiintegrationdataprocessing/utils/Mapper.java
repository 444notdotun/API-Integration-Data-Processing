package com.apiintegration.apiintegrationdataprocessing.utils;

import com.apiintegration.apiintegrationdataprocessing.dtos.response.GenderResponse;
import com.apiintegration.apiintegrationdataprocessing.model.Gender;

import java.time.LocalDateTime;

public class Mapper {

    public static GenderResponse mapGenderToApiResponse(Gender gender, boolean isConfident) {
        GenderResponse apiResponse = new GenderResponse();
        apiResponse.setName(gender.getName());
        apiResponse.setGender(gender.getGender());
        apiResponse.setProbability(gender.getProbability());
        apiResponse.setSample_size(gender.getCount());
        apiResponse.setIs_confident(isConfident);
        apiResponse.setProcessed_at(LocalDateTime.now().toString());
        return apiResponse;
    }
}
