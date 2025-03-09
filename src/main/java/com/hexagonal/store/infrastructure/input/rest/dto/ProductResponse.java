package com.hexagonal.store.infrastructure.input.rest.dto;

import com.hexagonal.store.domain.model.ProductStatus;
import java.math.BigDecimal;

public record ProductResponse(
    Long id,
    String name,
    String description,
    BigDecimal price,
    Integer stock,
    ProductStatus status
) {}
