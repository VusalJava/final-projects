package com.amr.project.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CartItemDto {
    private Long id;
    private int quantity;
    private Long userId;
    private ItemDto item;
}