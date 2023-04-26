package com.nicodoss.tpspring.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nicodoss.tpspring.enums.ZonePays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class PaysDto {
    private String codePays;
    private String nomPays;
    @JsonProperty("indicatif")
    private String  indicatifReseau;
    private ZonePays zonePays;
}
