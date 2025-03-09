package com.hexagonal.store.application.port.input;

import com.hexagonal.store.domain.model.Product;
import java.util.List;

public interface RetrieveProductUseCase {
    List<Product> getAllProducts();
}
