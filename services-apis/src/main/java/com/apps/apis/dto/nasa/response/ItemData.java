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
public class ItemData {

    @JsonProperty("album")
    private List<String> album;

    @JsonProperty("center")
    private String center;

    @JsonProperty("date_created")
    private String dateCreated;

    @JsonProperty("description")
    private String description;

    @JsonProperty("description_508")
    private String description_508;

    @JsonProperty("keywords")
    private List<String> keywords;

    @JsonProperty("location")
    private String location;

    @JsonProperty("media_type")
    private String mediaType;

    @JsonProperty("nasa_id")
    private String nasaId;

    @JsonProperty("secondary_creator")
    private String secondary_creator;

    @JsonProperty("photographer")
    private String photographer;

    @JsonProperty("title")
    private String title;

}
