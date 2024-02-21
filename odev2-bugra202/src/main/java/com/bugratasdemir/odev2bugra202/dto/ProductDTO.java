package com.bugratasdemir.odev2bugra202.dto;

import com.bugratasdemir.odev2bugra202.entity.Category;
import com.bugratasdemir.odev2bugra202.enums.ProductStatus;
import java.time.LocalDateTime;

public record ProductDTO(Long id,
                         String name,
                         Double price,
                         LocalDateTime expirationDate,
                         String description,
                         ProductStatus status,
                         Category category) {}
