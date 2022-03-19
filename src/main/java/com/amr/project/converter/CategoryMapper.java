package com.amr.project.converter;

import com.amr.project.model.dto.CategoryDto;
import com.amr.project.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ItemMapper.class)
public interface CategoryMapper extends MapperInterface<CategoryDto, Category> {
}