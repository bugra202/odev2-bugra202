package com.bugratasdemir.odev2bugra202.repository;

import com.bugratasdemir.odev2bugra202.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


}
