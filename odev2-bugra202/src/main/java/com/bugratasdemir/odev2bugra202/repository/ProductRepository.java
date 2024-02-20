package com.bugratasdemir.odev2bugra202.repository;

import com.bugratasdemir.odev2bugra202.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
