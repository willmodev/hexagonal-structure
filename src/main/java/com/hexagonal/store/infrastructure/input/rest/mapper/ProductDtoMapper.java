package com.hexagonal.store.infrastructure.input.rest.mapper;

import com.hexagonal.store.domain.model.Product;
import com.hexagonal.store.infrastructure.input.rest.dto.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {
    
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "stock", source = "stock")
    @Mapping(target = "status", source = "status")
    ProductResponse toResponse(Product product);

    List<ProductResponse> toResponseList(List<Product> products);
}
