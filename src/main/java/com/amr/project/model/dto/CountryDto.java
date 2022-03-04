package com.amr.project.model.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class CountryDto {
    private Long id;
    private String name;
    private List<CityDto> cities;
}