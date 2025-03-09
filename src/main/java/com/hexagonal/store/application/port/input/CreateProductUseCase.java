package com.hexagonal.store.application.port.input;

import com.hexagonal.store.domain.model.Product;

public interface CreateProductUseCase {
    Product createProduct(String name, String description, java.math.BigDecimal price, Integer stock);
}
