package com.hexagonal.store.infrastructure.input.rest.mapper;

import com.hexagonal.store.domain.model.Product;
import com.hexagonal.store.infrastructure.input.rest.dto.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper para convertir entre entidades de dominio Product y DTOs de la capa de presentación.
 * Utiliza MapStruct para generar automáticamente la implementación de los métodos de mapeo.
 */
@Mapper(componentModel = "spring")
public interface ProductDtoMapper {
    
    /**
     * Convierte una entidad de dominio Product a un DTO ProductResponse.
     *
     * @param product La entidad de dominio a convertir
     * @return El DTO ProductResponse con los datos del producto
     */
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "stock", source = "stock")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "category", source = "category")
    ProductResponse toResponse(Product product);

    /**
     * Convierte una lista de entidades de dominio Product a una lista de DTOs ProductResponse.
     *
     * @param products La lista de entidades de dominio a convertir
     * @return La lista de DTOs ProductResponse
     */
    List<ProductResponse> toResponseList(List<Product> products);
}
