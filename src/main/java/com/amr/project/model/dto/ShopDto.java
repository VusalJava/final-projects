package com.amr.project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String description;
    private Long countryId;
    private List<ItemDto> items;
    private ImageDto logo;
    private int count;
    private double rating;
    private UserDto user;
    private List<DiscountDto> discounts;
    private boolean isModerated;
    private boolean isModerateAccept;
    private String moderatedRejectReason;
    private boolean isPretendentToBeDeleted;
}
