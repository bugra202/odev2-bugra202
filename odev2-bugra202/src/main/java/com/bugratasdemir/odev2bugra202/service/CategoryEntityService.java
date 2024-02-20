package com.bugratasdemir.odev2bugra202.service;

import com.bugratasdemir.odev2bugra202.entity.Category;
import com.bugratasdemir.odev2bugra202.general.BaseEntityService;
import com.bugratasdemir.odev2bugra202.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryEntityService extends BaseEntityService<Category, CategoryRepository> {

    public CategoryEntityService(CategoryRepository repository) {
        super(repository);
    }
}
