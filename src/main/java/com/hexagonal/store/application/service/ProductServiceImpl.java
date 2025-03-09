package com.hexagonal.store.application.service;

import com.hexagonal.store.application.port.input.CreateProductUseCase;
import com.hexagonal.store.application.port.input.RetrieveProductUseCase;
import com.hexagonal.store.application.port.output.ProductRepository;
import com.hexagonal.store.domain.model.Product;
import com.hexagonal.store.domain.model.ProductStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Implementaciu00f3n de los casos de uso relacionados con productos.
 * Esta clase implementa las interfaces de puerto de entrada definidas en la capa de aplicaciu00f3n.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements CreateProductUseCase, RetrieveProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(String name, String description, BigDecimal price, Integer stock) {
        Product product = new Product(
            null, // El ID seru00e1 generado por la base de datos
            name,
            description,
            price,
            stock,
            ProductStatus.ACTIVO
        );
        
        return productRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
