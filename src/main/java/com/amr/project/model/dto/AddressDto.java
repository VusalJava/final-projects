package com.amr.project.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AddressDto {
    private Long id;
    private String cityIndex;
    private CityDto city;
    private String street;
    private String house;
    private UserDto user;
}