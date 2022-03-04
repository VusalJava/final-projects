package com.amr.project.model.dto;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
public class ItemDto {
    private Long id;
    private String name;
    private BigDecimal basePrice;
    private BigDecimal price;
    private Long categoryId;
    private List<ImageDto> imagesDto;
    private List<ReviewDto> reviewsDto;
    private int count;
    private double rating;
    private String description;
    private int discount;
    private ShopDto shop;
    private boolean isModerated;
    private String moderatedRejectReason;
    private boolean isPretendedToBeDeleted;
}
