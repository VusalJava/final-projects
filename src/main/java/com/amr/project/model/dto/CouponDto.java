package com.amr.project.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CouponDto {
    private Long id;
    private int sum;
    private int minOrder;
    private UserDto user;
    private Long shopId;
}