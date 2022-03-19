package com.amr.project.converter;

import com.amr.project.model.dto.CartItemDto;
import com.amr.project.model.entity.CartItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ShopMapper.class, ItemMapper.class})
public interface CartItemMapper extends MapperInterface<CartItemDto, CartItem> {

}