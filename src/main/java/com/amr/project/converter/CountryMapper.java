package com.amr.project.converter;

import com.amr.project.model.dto.CountryDto;
import com.amr.project.model.entity.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CityMapper.class, ShopMapper.class})
public interface CountryMapper extends MapperInterface<CountryDto, Country> {
}