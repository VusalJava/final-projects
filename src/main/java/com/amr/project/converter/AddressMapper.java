package com.amr.project.converter;

import com.amr.project.model.dto.AddressDto;
import com.amr.project.model.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CityMapper.class,
        UserMapper.class, ShopMapper.class, OrderMapper.class})
public interface AddressMapper extends MapperInterface<AddressDto, Address> {

}