package com.apps.apis.dto.nasa.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Collection {

    @JsonProperty("version")
    private String version;

    @JsonProperty("href")
    private String href;

    @JsonProperty("items")
    private List<Item> items;

    @JsonProperty("metadata")
    private Metadata metadata;

    @JsonProperty("links")
    private List<Link> links;

}
