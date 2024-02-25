package com.bugratasdemir.odev2bugra202.request;

import com.bugratasdemir.odev2bugra202.entity.Category;

import java.time.LocalDateTime;

public record ProductSaveRequest(String name,
                                 Double price,
                                 LocalDateTime expirationDate,
                                 String description,
                                 Long category_id) {}
