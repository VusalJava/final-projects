package com.amr.project.converter;

import com.amr.project.model.dto.CouponDto;
import com.amr.project.model.entity.Coupon;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface CouponMapper extends MapperInterface<CouponDto, Coupon> {
}
