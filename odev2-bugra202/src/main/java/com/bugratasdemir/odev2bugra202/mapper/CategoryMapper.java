package com.bugratasdemir.odev2bugra202.mapper;

import com.bugratasdemir.odev2bugra202.dto.CategoryDTO;
import com.bugratasdemir.odev2bugra202.entity.Category;
import com.bugratasdemir.odev2bugra202.request.CategorySaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    CategoryDTO convertToCategoryDTO(Category category);
    List<CategoryDTO> convertToCategoryDTOs(List<Category> categoryList);
    Category convertToCategory(CategorySaveRequest request);
}
