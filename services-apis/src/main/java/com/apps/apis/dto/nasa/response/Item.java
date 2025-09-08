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
public class Item {

    @JsonProperty("href")
    private String href;

    @JsonProperty("data")
    private List<ItemData> data;

    @JsonProperty("links")
    private List<ItemLink> links;

}
