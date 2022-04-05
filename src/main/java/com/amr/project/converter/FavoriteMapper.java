package com.amr.project.converter;

import com.amr.project.model.dto.FavoriteDto;
import com.amr.project.model.entity.Favorite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ShopMapper.class, UserMapper.class, ItemMapper.class})
public interface FavoriteMapper extends MapperInterface<FavoriteDto, Favorite> {
    @Mapping(target = "userId", source = "user.id")
    @Override
    FavoriteDto toDto(Favorite entity);
}
