package com.amr.project.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MainPageDto {
    private UserDto user;
    private List<ItemDto> itemDtoList;
    private List<ShopDto> shopDtoList;
    private int itemCount;
    private int shopCount;
    private List<CategoryDto> categories;
}
