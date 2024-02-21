package com.bugratasdemir.odev2bugra202.service;

import com.bugratasdemir.odev2bugra202.entity.Product;
import com.bugratasdemir.odev2bugra202.general.BaseEntityService;
import com.bugratasdemir.odev2bugra202.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductEntityService extends BaseEntityService<Product, ProductRepository> {
    protected ProductEntityService(ProductRepository repository) {
        super(repository);
    }
}