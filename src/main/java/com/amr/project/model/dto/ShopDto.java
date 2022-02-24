package com.amr.project.model.dto;

import com.amr.project.model.entity.Discount;
import com.amr.project.model.entity.Image;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ShopDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String description;
    private Long countryId;
    private List<ItemDto> items;
    private Image logo;
    private int count;
    private double rating;
    private UserDto user;
    private List<Discount> discounts;
    private boolean isModerated;
    private boolean isModerateAccept;
    private String moderatedRejectReason;
    private boolean isPretendentToBeDeleted;

}
