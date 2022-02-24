package com.amr.project.converter;

import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.dto.UserDto;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ItemMapper.class, UserMapper.class})
public interface ShopMapper {
    ShopMapper INSTANCE = Mappers.getMapper(ShopMapper.class);

    @Mapping(target = "items", ignore = true)
    @Mapping(target = "user", qualifiedByName = "clearUser")
    ShopDto toDto(Shop shop);
    Iterable<ShopDto> toDto(Iterable<Shop> shop);

    @Named("clearUser")
    @Mapping(target = "shops", ignore = true)
    UserDto toDto(User user);
}
