package com.amr.project.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SearchPageDto {
    private List<ItemDto> searchItems;
    private List<ShopDto> searchShops;
}
