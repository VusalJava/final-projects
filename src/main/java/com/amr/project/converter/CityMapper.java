package com.amr.project.converter;

import com.amr.project.model.dto.CityDto;
import com.amr.project.model.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, CountryMapper.class})
public interface CityMapper extends MapperInterface<CityDto, City> {
    @Mapping(target = "countryId", source = "country.id")
    @Override
    CityDto toDto(City entity);
}