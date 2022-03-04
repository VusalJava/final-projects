package com.amr.project.converter;

import com.amr.project.model.dto.CategoryDto;
import com.amr.project.model.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toDto(Category category);
    List<CategoryDto> toDto(List<Category> category);
}
