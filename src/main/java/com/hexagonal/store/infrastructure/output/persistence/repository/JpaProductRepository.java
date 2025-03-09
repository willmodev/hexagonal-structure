package com.hexagonal.store.infrastructure.output.persistence.repository;

import com.hexagonal.store.infrastructure.output.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {
}
