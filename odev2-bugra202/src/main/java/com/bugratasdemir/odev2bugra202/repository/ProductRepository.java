package com.bugratasdemir.odev2bugra202.repository;

import com.bugratasdemir.odev2bugra202.entity.Product;
import com.bugratasdemir.odev2bugra202.enums.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByCategory_idAndStatus(Long id,ProductStatus status);
    List<Product> findProductByExpirationDateIsLessThanEqualAndStatus(LocalDateTime localDateTime, ProductStatus status);
    List<Product> findProductByStatus(ProductStatus status);
}
