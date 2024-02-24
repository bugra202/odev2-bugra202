package com.bugratasdemir.odev2bugra202.service;

import com.bugratasdemir.odev2bugra202.entity.Product;
import com.bugratasdemir.odev2bugra202.enums.ProductStatus;
import com.bugratasdemir.odev2bugra202.general.BaseEntityService;
import com.bugratasdemir.odev2bugra202.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductEntityService extends BaseEntityService<Product, ProductRepository> {
    protected ProductEntityService(ProductRepository repository) {
        super(repository);
    }
    public Product findByCategoryId(Long id){
        return getRepository().findProductByCategory_Id(id);
    }
    public List<Product> findByStatus(ProductStatus status){
        return getRepository().findByStatus(status);
    }
}