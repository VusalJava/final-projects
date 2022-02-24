package com.amr.project.converter;

import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.dto.UserDto;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ShopMapper.class})
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "shops", qualifiedByName = "clearShop")
    UserDto toDto(User user);
    Iterable<UserDto> toDto(Iterable<User> user);

    @Named("clearShop")
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "items", ignore = true)
    ShopDto toDto(Shop shop);
}
