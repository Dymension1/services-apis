package com.apps.apis.services;

import com.apps.apis.utils.ApiResponse;

public interface NasaService {

    ApiResponse<?> getData(String q);

}
