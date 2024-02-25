package com.bugratasdemir.odev2bugra202.controller.contract.impl;

import com.bugratasdemir.odev2bugra202.controller.contract.ProductControllerContract;
import com.bugratasdemir.odev2bugra202.dto.ProductDTO;
import com.bugratasdemir.odev2bugra202.entity.Category;
import com.bugratasdemir.odev2bugra202.entity.Product;
import com.bugratasdemir.odev2bugra202.enums.ProductStatus;
import com.bugratasdemir.odev2bugra202.errormessage.BaseErrorMessage;
import com.bugratasdemir.odev2bugra202.errormessage.GeneralErrorMessage;
import com.bugratasdemir.odev2bugra202.general.BusinessException;
import com.bugratasdemir.odev2bugra202.mapper.ProductMapper;
import com.bugratasdemir.odev2bugra202.request.ProductBatchUpdatePriceRequest;
import com.bugratasdemir.odev2bugra202.request.ProductSaveRequest;
import com.bugratasdemir.odev2bugra202.request.ProductUpdatePriceRequest;
import com.bugratasdemir.odev2bugra202.service.CategoryEntityService;
import com.bugratasdemir.odev2bugra202.service.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductControllerContractImpl implements ProductControllerContract {

    private final ProductEntityService productEntityService;
    private final CategoryEntityService categoryEntityService;

    public ProductDTO save(ProductSaveRequest request) {

        Product product = ProductMapper.INSTANCE.convertToProduct(request);

        Category category = categoryEntityService.findByIdWithControl(request.category_id());

        product.setCategory(category);

        product = productEntityService.save(product);

        return ProductMapper.INSTANCE.convertToProductDTO(product);
    }
    @Override
    public List<ProductDTO> findAll() {

        List<Product> productList = productEntityService.findAllAndStatusActive(ProductStatus.ACTIVE);

        return ProductMapper.INSTANCE.convertToProductDTOs(productList);
    }
    @Override
    public List<ProductDTO> findAllByExpirationDateLE(LocalDateTime dateTime) {

        List<Product> productList = productEntityService.findAllByExpirationDateLE(dateTime, ProductStatus.ACTIVE);

        return ProductMapper.INSTANCE.convertToProductDTOs(productList);

    }
    @Override
    public ProductDTO findById(Long id) {

        Product product = productEntityService.findByIdWithControl(id);

        if (product.getStatus().equals(ProductStatus.ACTIVE)){
            return ProductMapper.INSTANCE.convertToProductDTO(product);
        }

        return null;
    }
    @Override
    public ProductDTO findByCategoryId(Long id) {

        Product product = productEntityService.findByCategoryId(id);

        return ProductMapper.INSTANCE.convertToProductDTO(product);
    }
    @Override
    public ProductDTO updatePrice(Long id, ProductUpdatePriceRequest request) {

        Product product = productEntityService.findByIdWithControl(id);

        if(product.getStatus().equals(ProductStatus.ACTIVE)){
            product.setPrice(request.price());

            productEntityService.save(product);

            return ProductMapper.INSTANCE.convertToProductDTO(product);
        }
        return null;
    }

    @Override
    public List<ProductDTO> batchUpdatePrice(ProductBatchUpdatePriceRequest request) {

        return request.id().stream()
                .map(productEntityService::findByIdWithControl)
                .filter(product -> product.getStatus() == ProductStatus.ACTIVE)
                .peek(product -> {
                    product.setPrice(request.price());
                    productEntityService.save(product);
                })
                .map(ProductMapper.INSTANCE::convertToProductDTO)
                .toList();
    }
    @Override
    public ProductDTO activate(Long id) {

        Product product = productEntityService.findByIdWithControl(id);

        product.setStatus(ProductStatus.ACTIVE);

        productEntityService.save(product);

        return ProductMapper.INSTANCE.convertToProductDTO(product);

    }
    @Override
    public ProductDTO deactivate(Long id) {

        Product product = productEntityService.findByIdWithControl(id);

        product.setStatus(ProductStatus.PASSIVE);

        productEntityService.save(product);

        return ProductMapper.INSTANCE.convertToProductDTO(product);
    }
}