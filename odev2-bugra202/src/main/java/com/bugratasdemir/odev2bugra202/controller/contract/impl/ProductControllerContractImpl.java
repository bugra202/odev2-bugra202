package com.bugratasdemir.odev2bugra202.controller.contract.impl;

import com.bugratasdemir.odev2bugra202.controller.contract.ProductControllerContract;
import com.bugratasdemir.odev2bugra202.dto.ProductDTO;
import com.bugratasdemir.odev2bugra202.entity.Product;
import com.bugratasdemir.odev2bugra202.mapper.ProductMapper;
import com.bugratasdemir.odev2bugra202.request.ProductSaveRequest;
import com.bugratasdemir.odev2bugra202.service.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductControllerContractImpl implements ProductControllerContract {

    private final ProductEntityService productEntityService;
    @Override
    public ProductDTO save(ProductSaveRequest request) {

        Product product = ProductMapper.INSTANCE.convertToProduct(request);

        product = productEntityService.save(product);

        ProductDTO productDTO = ProductMapper.INSTANCE.convertToProductDTO(product);

        return productDTO;
    }
    @Override
    public List<ProductDTO> getAllProducts() {

        List<Product> productList = productEntityService.findAll();

        List<Product> activeProducts = productList.stream()
                .filter(product -> "Active".equals(product.getStatus().getStringValue()))
                .collect(Collectors.toList());

        List<ProductDTO> productDTOList = ProductMapper.INSTANCE.convertToProductDTOs(activeProducts);

        return productDTOList;
    }
}
