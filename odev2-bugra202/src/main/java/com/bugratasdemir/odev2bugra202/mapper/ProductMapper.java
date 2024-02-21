package com.bugratasdemir.odev2bugra202.mapper;

import com.bugratasdemir.odev2bugra202.dto.ProductDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductDTO INSTANCE = Mappers.getMapper(ProductDTO.class);
}
