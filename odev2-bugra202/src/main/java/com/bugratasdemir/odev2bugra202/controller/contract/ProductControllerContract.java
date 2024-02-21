package com.bugratasdemir.odev2bugra202.controller.contract;

import com.bugratasdemir.odev2bugra202.dto.ProductDTO;
import com.bugratasdemir.odev2bugra202.request.ProductSaveRequest;

import java.util.List;

public interface ProductControllerContract {
    List<ProductDTO> getAllProducts();
    ProductDTO save(ProductSaveRequest request);
}
