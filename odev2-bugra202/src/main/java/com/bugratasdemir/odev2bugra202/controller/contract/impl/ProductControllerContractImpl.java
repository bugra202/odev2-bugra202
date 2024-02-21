package com.bugratasdemir.odev2bugra202.controller.contract.impl;

import com.bugratasdemir.odev2bugra202.controller.contract.ProductControllerContract;
import com.bugratasdemir.odev2bugra202.entity.Product;
import com.bugratasdemir.odev2bugra202.service.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ProductControllerContractImpl implements ProductControllerContract {

    private final ProductEntityService productEntityService;
    @Override
    public List<Product> getAllProducts() {

        List<>
    }
}
