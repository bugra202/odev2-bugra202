package com.bugratasdemir.odev2bugra202.request;

import com.bugratasdemir.odev2bugra202.entity.Category;
import com.bugratasdemir.odev2bugra202.enums.ProductStatus;

import java.time.LocalDateTime;

public record ProductSaveRequest(String name,
                                 Double price,
                                 LocalDateTime expirationDate,
                                 String description,
                                 ProductStatus status,
                                 Category category) {}
