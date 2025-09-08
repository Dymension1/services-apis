package com.apps.apis;

import com.apps.apis.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ServicesApisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicesApisApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Autowired
            private AppConfig config;

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                String regex = "\\s*,\\s*";

                registry.addMapping("/**")
                        .allowedOrigins(config.getAllowedOrigins().split(regex))
                        .allowedMethods(config.getAllowedMethods().split(regex))
                        .allowedHeaders(config.getAllowedHeaders().split(regex))
                        .exposedHeaders(config.getExposedHeaders().split(regex));
            }
        };
    }

}
