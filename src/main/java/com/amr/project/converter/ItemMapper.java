package com.amr.project.converter;

import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, OrderMapper.class,
        ShopMapper.class, FavoriteMapper.class, ImageMapper.class, ReviewMapper.class, CartItemMapper.class})
public interface ItemMapper extends MapperInterface<ItemDto, Item> {
    @Mapping(target = "shopId", source = "shop.id")
    @Override
    ItemDto toDto(Item entity);
}