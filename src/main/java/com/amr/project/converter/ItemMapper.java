package com.amr.project.converter;

import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper (componentModel = "spring")
public interface ItemMapper {

    ItemDto toDto(Item item);

    @Named("dtoForMainPage")
    @Mapping(target = "shop", qualifiedByName = "clearShop")
    ItemDto toDtoWithoutShopDetails(Item item);

    @IterableMapping(qualifiedByName = "dtoForMainPage")
    Iterable<ItemDto> toDtoWithoutShopDetails(Iterable<Item> item);

    @Named("clearShop")
    @Mapping(target="items", ignore = true)
    @Mapping(target="user", ignore = true)
    ShopDto toDto(Shop shop);

}
