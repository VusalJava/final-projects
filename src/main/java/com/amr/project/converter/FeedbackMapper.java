package com.amr.project.converter;

import com.amr.project.model.dto.FeedbackDto;
import com.amr.project.model.entity.Feedback;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ShopMapper.class, UserMapper.class})
public interface FeedbackMapper extends MapperInterface<FeedbackDto, Feedback> {
}
