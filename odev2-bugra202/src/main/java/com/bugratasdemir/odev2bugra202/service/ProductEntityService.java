package com.bugratasdemir.odev2bugra202.service;

import com.bugratasdemir.odev2bugra202.entity.Product;
import com.bugratasdemir.odev2bugra202.enums.ProductStatus;
import com.bugratasdemir.odev2bugra202.general.BaseEntityService;
import com.bugratasdemir.odev2bugra202.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductEntityService extends BaseEntityService<Product, ProductRepository> {
    protected ProductEntityService(ProductRepository repository) {
        super(repository);
    }
    public Product findByCategoryId(Long id){
        return getRepository().findByCategory_idAndStatus(id,ProductStatus.ACTIVE);
    }
    public List<Product> findByStatus(ProductStatus status){
        return getRepository().findByStatus(status);
    }
    public List<Product> findAllByExpirationDateLE(LocalDateTime localDateTime, ProductStatus status){
        return getRepository().findProductByExpirationDateIsLessThanEqualAndStatus(localDateTime, status);
    }
    public List<Product> findAllAndStatusActive(ProductStatus status){
        return getRepository().findProductByStatus(status);
    }
    public Product findByIdAndStatus(Long id,ProductStatus status){
        return getRepository().findByIdAndStatus(id,status);
    }
}