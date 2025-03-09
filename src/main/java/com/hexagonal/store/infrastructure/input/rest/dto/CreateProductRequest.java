package com.hexagonal.store.infrastructure.input.rest.dto;

import com.hexagonal.store.domain.model.ProductCategory;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record CreateProductRequest(
    @NotBlank(message = "El nombre del producto es requerido")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9 ñÑáéíóúÁÉÍÓÚ\\-_.:,]+$", 
            message = "El nombre contiene caracteres no válidos")
    String name,
    
    @Size(max = 500, message = "La descripción no puede exceder los 500 caracteres")
    String description,
    
    @NotNull(message = "El precio es requerido")
    @Positive(message = "El precio debe ser mayor que cero")
    @Digits(integer = 10, fraction = 2, 
            message = "El precio debe tener máximo 10 dígitos enteros y 2 decimales")
    BigDecimal price,
    
    @NotNull(message = "El stock es requerido")
    @PositiveOrZero(message = "El stock no puede ser negativo")
    @Max(value = 999999, message = "El stock no puede ser mayor a 999999")
    Integer stock,
    
    ProductCategory category
) {}
