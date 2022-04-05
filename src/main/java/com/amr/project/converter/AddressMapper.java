package com.amr.project.converter;

import com.amr.project.model.dto.AddressDto;
import com.amr.project.model.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CityMapper.class,
        UserMapper.class, ShopMapper.class, OrderMapper.class})
public interface AddressMapper extends MapperInterface<AddressDto, Address> {
    @Mapping(target = "cityId", source = "city.id")
    @Override
    AddressDto toDto(Address entity);

}