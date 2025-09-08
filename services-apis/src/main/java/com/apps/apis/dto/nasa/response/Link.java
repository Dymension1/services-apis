package com.apps.apis.dto.nasa.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    @JsonProperty("rel")
    private String rel;

    @JsonProperty("prompt")
    private String prompt;

    @JsonProperty("href")
    private String href;

}
