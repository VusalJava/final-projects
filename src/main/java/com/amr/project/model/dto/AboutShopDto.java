package com.amr.project.model.dto;

import com.amr.project.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AboutShopDto {
    private Long id;
    private String name;
    private String description;
    private Double rating;
    private Double averageRating;
    private List<ItemDto> items = new ArrayList<>();
    private List<DiscountDto> discounts = new ArrayList<>();
    private List<CategoryDto> categoryItem;
    private long countryId;
    private String email;
    private String phone;
}
