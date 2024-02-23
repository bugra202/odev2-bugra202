package com.bugratasdemir.odev2bugra202.controller.contract;

import com.bugratasdemir.odev2bugra202.dto.CategoryDTO;
import com.bugratasdemir.odev2bugra202.request.CategorySaveRequest;
import java.util.List;

public interface CategoryControllerContract {
    List<CategoryDTO> findAll();
    CategoryDTO save(CategorySaveRequest request);
    CategoryDTO findById(Long id);
    void delete(Long id);
}
