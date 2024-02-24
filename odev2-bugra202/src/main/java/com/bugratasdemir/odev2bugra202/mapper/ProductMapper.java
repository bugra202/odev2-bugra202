package com.bugratasdemir.odev2bugra202.mapper;

import com.bugratasdemir.odev2bugra202.dto.ProductDTO;
import com.bugratasdemir.odev2bugra202.entity.Product;
import com.bugratasdemir.odev2bugra202.request.ProductSaveRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDTO convertToProductDTO(Product product);
    List<ProductDTO> convertToProductDTOs(List<Product> product);
    @Mapping(target = "status",constant = "ACTIVE")
    Product convertToProduct(ProductSaveRequest request);
}
