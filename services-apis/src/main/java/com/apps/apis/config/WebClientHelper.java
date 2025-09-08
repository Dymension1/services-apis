package com.apps.apis.config;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebClientHelper {

    private final WebClient.Builder webClientBuilder;

    public WebClientHelper(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public String consumirApi(String baseUrl, String path) {
        WebClient client = webClientBuilder.baseUrl(baseUrl).build();
        return client.get()
                .uri(path)
                .retrieve()
                .bodyToMono(String.class)
                .block(); // Ojo: block() lo vuelve síncrono
    }

}
