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
public class ItemLink {

    @JsonProperty("href")
    private String href;

    @JsonProperty("rel")
    private String rel;

    @JsonProperty("render")
    private String render;

    @JsonProperty("width")
    private int width;

    @JsonProperty("height")
    private int height;

    @JsonProperty("size")
    private long size;

}
