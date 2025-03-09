package com.hexagonal.store.application.port.input;

import com.hexagonal.store.domain.model.Product;
import com.hexagonal.store.domain.model.ProductCategory;

/**
 * Puerto de entrada que define las operaciones para crear productos.
 * Siguiendo los principios de la arquitectura hexagonal, esta interfaz actúa como un puerto
 * que permite a los adaptadores de entrada interactuar con la lógica de aplicación.
 */
public interface CreateProductUseCase {
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
    Product createProduct(String name, String description, java.math.BigDecimal price, Integer stock, ProductCategory category);
    
    /**
     * Crea un nuevo producto en el sistema con categoría por defecto (OTHER).
     *
     * @param name        Nombre del producto
     * @param description Descripción del producto
     * @param price       Precio del producto
     * @param stock       Cantidad disponible en inventario
     * @return El producto creado
     */
    default Product createProduct(String name, String description, java.math.BigDecimal price, Integer stock) {
        return createProduct(name, description, price, stock, ProductCategory.OTHER);
    }
}
