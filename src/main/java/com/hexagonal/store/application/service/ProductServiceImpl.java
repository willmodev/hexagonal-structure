package com.hexagonal.store.application.service;

import com.hexagonal.store.application.port.input.CreateProductUseCase;
import com.hexagonal.store.application.port.input.RetrieveProductUseCase;
import com.hexagonal.store.application.port.output.ProductRepository;
import com.hexagonal.store.application.service.ProductService;
import com.hexagonal.store.domain.model.Product;
import com.hexagonal.store.domain.model.ProductCategory;
import com.hexagonal.store.domain.model.ProductStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Implementación del servicio de productos que implementa tanto la interfaz ProductService
 * como las interfaces de casos de uso para mantener compatibilidad.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService, CreateProductUseCase, RetrieveProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(String name, String description, BigDecimal price, Integer stock, ProductCategory category) {
        Product product = new Product(
            null, // El ID será generado por la base de datos
            name,
            description,
            price,
            stock,
            ProductStatus.ACTIVO,
            category
        );
        
        return productRepository.save(product);
    }
    
    @Override
    public Product createProduct(String name, String description, BigDecimal price, Integer stock) {
        return createProduct(name, description, price, stock, ProductCategory.OTHER);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
