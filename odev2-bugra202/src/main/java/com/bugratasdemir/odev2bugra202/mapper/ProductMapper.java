package com.bugratasdemir.odev2bugra202.mapper;

import com.bugratasdemir.odev2bugra202.dto.ProductDTO;
import com.bugratasdemir.odev2bugra202.entity.Category;
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
    @Mapping(target = "category", source = "category_id",qualifiedByName = "mapCategoryIdToCategory")
    Product convertToProduct(ProductSaveRequest request);
    @Mapping(target = "id", source = "category_id")
    @Named("mapCategoryIdToCategory")
    Category mapCategoryIdToCategory(Long category_id);
}
