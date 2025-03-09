package com.hexagonal.store.application.service;

import com.hexagonal.store.domain.model.Product;
import com.hexagonal.store.domain.model.ProductCategory;

import java.math.BigDecimal;
import java.util.List;

/**
 * Interfaz que define el contrato del servicio de productos.
 * Siguiendo los principios de la arquitectura hexagonal y SOLID,
 * esta interfaz actúa como una abstracción que permite desacoplar
 * los adaptadores de entrada (controladores) de la implementación concreta.
 */
public interface ProductService {
    
    /**
     * Crea un nuevo producto en el sistema.
     *
     * @param name        Nombre del producto
     * @param description Descripción del producto
     * @param price       Precio del producto
     * @param stock       Cantidad disponible en inventario
     * @param category    Categoría del producto
     * @return El producto creado
     */
    Product createProduct(String name, String description, BigDecimal price, Integer stock, ProductCategory category);
    
    /**
     * Crea un nuevo producto en el sistema con categoría por defecto (OTHER).
     *
     * @param name        Nombre del producto
     * @param description Descripción del producto
     * @param price       Precio del producto
     * @param stock       Cantidad disponible en inventario
     * @return El producto creado
     */
    Product createProduct(String name, String description, BigDecimal price, Integer stock);
    
    /**
     * Obtiene todos los productos del sistema.
     *
     * @return Lista de todos los productos
     */
    List<Product> getAllProducts();
}
