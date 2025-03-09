package com.hexagonal.store.infrastructure.input.rest;

import com.hexagonal.store.application.port.input.CreateProductUseCase;
import com.hexagonal.store.application.port.input.RetrieveProductUseCase;
import com.hexagonal.store.infrastructure.input.rest.dto.CreateProductRequest;
import com.hexagonal.store.infrastructure.input.rest.dto.ProductResponse;
import com.hexagonal.store.infrastructure.input.rest.mapper.ProductDtoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Products", description = "API para la gestión de productos")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final RetrieveProductUseCase retrieveProductUseCase;
    private final ProductDtoMapper productDtoMapper;

    @Operation(summary = "Crear un nuevo producto", 
               description = "Crea un nuevo producto con los datos proporcionados")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Producto creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos de producto inválidos"),
        @ApiResponse(responseCode = "429", description = "Demasiadas solicitudes")
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody CreateProductRequest request) {
        var product = createProductUseCase.createProduct(
            request.name(),
            request.description(),
            request.price(),
            request.stock(),
            request.category()
        );
        
        var response = productDtoMapper.toResponse(product);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Obtener todos los productos", 
               description = "Retorna una lista de todos los productos disponibles")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de productos obtenida exitosamente"),
        @ApiResponse(responseCode = "429", description = "Demasiadas solicitudes")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        var products = retrieveProductUseCase.getAllProducts();
        var productResponses = productDtoMapper.toResponseList(products);
        return ResponseEntity.ok(productResponses);
    }
}
