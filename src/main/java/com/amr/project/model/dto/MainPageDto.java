package com.amr.project.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MainPageDto {
    private UserDto user;
    private List<ItemDto> popularItems;
    private List<ShopDto> popularShops;
    private List<CategoryDto> categories;
}
