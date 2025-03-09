package com.hexagonal.store.domain.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("No se encontró el producto con ID: " + id);
    }
}
