package com.amr.project.converter;

import com.amr.project.model.dto.ReviewDto;
import com.amr.project.model.entity.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ShopMapper.class, ItemMapper.class})
public interface ReviewMapper extends MapperInterface<ReviewDto, Review> {
}
