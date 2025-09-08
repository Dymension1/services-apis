package com.apps.apis.services.impl;

import com.apps.apis.config.WebClientHelper;
import com.apps.apis.dto.nasa.response.NasaResponse;
import com.apps.apis.services.NasaService;
import com.apps.apis.utils.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Log4j2
public class NasaServiceImpl implements NasaService {

    private final WebClientHelper webClientHelper;

    public NasaServiceImpl(WebClientHelper webClientHelper) {
        this.webClientHelper = webClientHelper;
    }

    @Value("${nasa-apis-path.images}")
    private String baseURL;

    @Value("${nasa-apis-path.pathSearch}")
    private String pathSearch;

    @Override
    public ApiResponse<?> getData(String q) {
        log.info("getData is invoked");
        try {
            String apiResponse = webClientHelper.consumirApi(baseURL, buildPath(q));
            if(apiResponse == null) {
                throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, HttpStatus.PRECONDITION_FAILED.getReasonPhrase());
            }

            ObjectMapper mapper = new ObjectMapper();
            NasaResponse response = mapper.readValue(apiResponse, NasaResponse.class);

            return new ApiResponse<>(response, HttpStatus.OK.name());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, e.getMessage());
        }
    }

    private String buildPath(String q){
        return pathSearch + "?q=" + q;
    }

}
