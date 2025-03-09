package com.hexagonal.store.infrastructure.output.persistence.mapper;

import com.hexagonal.store.domain.model.Product;
import com.hexagonal.store.infrastructure.output.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    
    ProductEntity toEntity(Product product);

    // Implementamos un método personalizado para el mapeo de entidad a dominio
    default Product toDomain(ProductEntity entity) {
        if (entity == null) {
            return null;
        }
        
        // Usamos el constructor completo con 7 parámetros explícitamente
        return new Product(
            entity.getId(),
            entity.getName(),
            entity.getDescription(),
            entity.getPrice(),
            entity.getStock(),
            entity.getStatus(),
            entity.getCategory()
        );
    }
}
