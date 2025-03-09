package com.hexagonal.store.infrastructure.output.persistence.adapter;

import com.hexagonal.store.application.port.output.ProductRepository;
import com.hexagonal.store.domain.model.Product;
import com.hexagonal.store.infrastructure.output.persistence.mapper.ProductMapper;
import com.hexagonal.store.infrastructure.output.persistence.repository.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final JpaProductRepository jpaRepository;
    private final ProductMapper mapper;

    @Override
    public Product save(Product product) {
        return mapper.toDomain(
            jpaRepository.save(
                mapper.toEntity(product)
            )
        );
    }

    @Override
    public List<Product> findAll() {
        return jpaRepository.findAll()
            .stream()
            .map(mapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaRepository.findById(id)
            .map(mapper::toDomain);
    }
}
