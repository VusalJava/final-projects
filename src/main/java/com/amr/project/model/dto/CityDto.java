package com.amr.project.model.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class CityDto {
    private Long id;
    private String name;
    private Long countryId;
    private List<AddressDto> addresses;
}