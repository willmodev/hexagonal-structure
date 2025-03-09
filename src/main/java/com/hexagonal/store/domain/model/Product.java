package com.hexagonal.store.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Entidad de dominio que representa un producto en el sistema.
 * Implementa comportamiento relacionado con la lógica de negocio de productos.
 */
public class Product {
    private final Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private ProductStatus status;
    private ProductCategory category;

    // Constructor principal con todos los parámetros
    public Product(Long id, String name, String description, BigDecimal price, Integer stock, ProductStatus status, ProductCategory category) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "name cannot be null");
        this.description = description;
        this.price = validatePrice(price);
        this.stock = validateStock(stock);
        this.status = Objects.requireNonNull(status, "status cannot be null");
        this.category = category != null ? category : ProductCategory.OTHER;
        updateStatusBasedOnStock();
    }
    
    // Constructor sobrecargado para mantener compatibilidad con el código existente
    public Product(Long id, String name, String description, BigDecimal price, Integer stock, ProductStatus status) {
        this(id, name, description, price, stock, status, ProductCategory.OTHER);
    }

    private BigDecimal validatePrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be greater than or equal to zero");
        }
        return price;
    }

    private Integer validateStock(Integer stock) {
        if (stock == null || stock < 0) {
            throw new IllegalArgumentException("Stock must be greater than or equal to zero");
        }
        return stock;
    }

    // Comportamiento de dominio
    public void updateStock(int quantity) {
        this.stock = validateStock(quantity);
        updateStatusBasedOnStock();
    }

    public void updatePrice(BigDecimal newPrice) {
        this.price = validatePrice(newPrice);
    }

    public void activate() {
        if (this.stock > 0) {
            this.status = ProductStatus.ACTIVO;
        } else {
            throw new IllegalStateException("Cannot activate product with no stock");
        }
    }

    public void deactivate() {
        this.status = ProductStatus.INACTIVO;
    }

    private void updateStatusBasedOnStock() {
        if (this.stock == 0 && this.status == ProductStatus.ACTIVO) {
            this.status = ProductStatus.AGOTADO;
        }
    }
    
    public void updateCategory(ProductCategory category) {
        this.category = Objects.requireNonNull(category, "category cannot be null");
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public ProductStatus getStatus() {
        return status;
    }
    
    public ProductCategory getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
