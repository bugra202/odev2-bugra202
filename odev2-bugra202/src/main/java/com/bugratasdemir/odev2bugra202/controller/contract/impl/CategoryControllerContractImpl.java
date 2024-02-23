package com.bugratasdemir.odev2bugra202.controller.contract.impl;

import com.bugratasdemir.odev2bugra202.controller.contract.CategoryControllerContract;
import com.bugratasdemir.odev2bugra202.dto.CategoryDTO;
import com.bugratasdemir.odev2bugra202.entity.Category;
import com.bugratasdemir.odev2bugra202.mapper.CategoryMapper;
import com.bugratasdemir.odev2bugra202.request.CategorySaveRequest;
import com.bugratasdemir.odev2bugra202.service.CategoryEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryControllerContractImpl implements CategoryControllerContract {

    private final CategoryEntityService categoryEntityService;
    @Override
    public CategoryDTO save(CategorySaveRequest request) {
        Category category = CategoryMapper.INSTANCE.convertToCategory(request);

        category = categoryEntityService.save(category);

        CategoryDTO categoryDTO = CategoryMapper.INSTANCE.convertToCategoryDTO(category);

        return categoryDTO;
    }
    @Override
    public List<CategoryDTO> findAll() {
        List<Category> category = categoryEntityService.findAll();

        List<CategoryDTO> productDTOList = CategoryMapper.INSTANCE.convertToCategoryDTOs(category);

        return productDTOList;
    }

    @Override
    public CategoryDTO findById(Long id) {

        Category category = categoryEntityService.findByIdWithControl(id);

        CategoryDTO categoryDTO = CategoryMapper.INSTANCE.convertToCategoryDTO(category);

        return  categoryDTO;

    }
    @Override
    public void delete(Long id) {
        categoryEntityService.delete(id); // delete için olmayan id verdiğimde expection yer mi ?
    }
}