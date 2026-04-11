package com.apiintegration.apiintegrationdataprocessing.utils;

import com.apiintegration.apiintegrationdataprocessing.dtos.response.GenderResponse;
import com.apiintegration.apiintegrationdataprocessing.model.Gender;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public class Mapper {

    public static GenderResponse mapGenderToApiResponse(Gender gender, boolean isConfident) {
        GenderResponse apiResponse = new GenderResponse();
        apiResponse.setName(gender.getName());
        apiResponse.setGender(gender.getGender());
        apiResponse.setProbability(gender.getProbability());
        apiResponse.setSample_size(gender.getCount());
        apiResponse.setIs_confident(isConfident);
        apiResponse.setProcessed_at(LocalDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS).toString());
        return apiResponse;
    }
}
