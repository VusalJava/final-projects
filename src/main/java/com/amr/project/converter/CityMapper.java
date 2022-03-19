package com.amr.project.converter;

import com.amr.project.model.dto.CityDto;
import com.amr.project.model.entity.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, CountryMapper.class})
public interface CityMapper extends MapperInterface<CityDto, City> {
}