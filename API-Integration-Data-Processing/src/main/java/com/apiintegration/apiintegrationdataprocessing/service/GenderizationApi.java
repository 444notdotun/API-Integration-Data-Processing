package com.apiintegration.apiintegrationdataprocessing.service;

import com.apiintegration.apiintegrationdataprocessing.dtos.response.GenderResponse;
import com.apiintegration.apiintegrationdataprocessing.exception.ApiCallException;
import com.apiintegration.apiintegrationdataprocessing.exception.InvalidUrlCallException;
import com.apiintegration.apiintegrationdataprocessing.exception.NullGenderNameOrCountException;
import com.apiintegration.apiintegrationdataprocessing.exception.UnprocessableNameException;
import com.apiintegration.apiintegrationdataprocessing.model.Gender;
import com.apiintegration.apiintegrationdataprocessing.utils.Mapper;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
public class GenderizationApi implements ApiIntegrationService{
    @Override
    public GenderResponse genderize(String name) {
        if (!name.matches("[a-zA-Z]+")) {
            throw new UnprocessableNameException("name must be a valid string");
        }
        String url = "https://api.genderize.io?name="+ URLEncoder.encode(name, StandardCharsets.UTF_8);
        HttpResponse<String> response = callApi(url);
        Gender gender = mapResponseToGender(response);
        validateGender(gender);
        boolean isConfident = isConfident(gender);
        return Mapper.mapGenderToApiResponse(gender,isConfident);
    }

    private static Gender mapResponseToGender(HttpResponse<String> response) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.body(),Gender.class);
    }

    private HttpResponse<String> callApi(String apiUrl){
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI(apiUrl))
                    .header("accept","application/json")
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException e) {
            throw new InvalidUrlCallException("invalid url");
        } catch (IOException | InterruptedException e) {
            throw new ApiCallException("Upstream API call failed:");
        }
    }

    private void validateGender(Gender gender){
        if(gender.getName()==null|| gender.getCount()==0){
            throw new NullGenderNameOrCountException("no prediction available for the provided name");
        }
    }

    private boolean isConfident(Gender gender){
        return gender.getProbability() >= 0.7 && gender.getCount() >= 100;
    }
}
