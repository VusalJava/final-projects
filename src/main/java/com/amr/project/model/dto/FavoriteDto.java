package com.amr.project.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FavoriteDto {
    private Long id;
    private Long itemId;
    private Long shopId;
    private UserDto user;
}