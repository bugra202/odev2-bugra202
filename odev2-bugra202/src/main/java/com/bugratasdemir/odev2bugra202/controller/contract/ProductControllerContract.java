package com.bugratasdemir.odev2bugra202.controller.contract;

import com.bugratasdemir.odev2bugra202.dto.ProductDTO;
import com.bugratasdemir.odev2bugra202.request.ProductActivateRequest;
import com.bugratasdemir.odev2bugra202.request.ProductDeactivateRequest;
import com.bugratasdemir.odev2bugra202.request.ProductSaveRequest;
import com.bugratasdemir.odev2bugra202.request.ProductUpdatePriceRequest;

import java.util.List;

public interface ProductControllerContract {
    List<ProductDTO> findAll();
    ProductDTO save(ProductSaveRequest request);
    ProductDTO findById(Long id);
    ProductDTO findByCategoryId (Long id);
    ProductDTO updatePrice(Long id, ProductUpdatePriceRequest request);
    ProductDTO activate(Long id, ProductActivateRequest request);
    ProductDTO deactivate(Long id, ProductDeactivateRequest request);

}
