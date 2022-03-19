package com.amr.project.converter;

import com.amr.project.model.dto.ImageDto;
import com.amr.project.model.entity.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ShopMapper.class)
public interface ImageMapper extends MapperInterface<ImageDto, Image> {
}