package com.hexagonal.store.infrastructure.input.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "Respuesta que contiene una lista de productos")
public record ProductListResponse(
    @Schema(description = "Lista de productos")
    List<ProductResponse> products
) {}
