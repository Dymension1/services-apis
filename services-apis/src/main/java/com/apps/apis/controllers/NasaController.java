package com.apps.apis.controllers;

import com.apps.apis.services.NasaService;
import com.apps.apis.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@AllArgsConstructor
@RequestMapping("/nasa")
public class NasaController {

    private NasaService nasaService;

    @GetMapping(value = "/getData", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<?> getData(@RequestParam("q") String q){
        try {
            return nasaService.getData(q);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, ex.getMessage());
        }
    }

}
