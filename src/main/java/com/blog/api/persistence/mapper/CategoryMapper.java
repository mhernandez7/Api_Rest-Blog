package com.blog.api.persistence.mapper;

import com.blog.api.domain.CategoryDto;
import com.blog.api.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    CategoryDto toCategoryDto(Category category);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target ="posts", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    Category toCatgory (CategoryDto categoryDto);

}
