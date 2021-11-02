package com.kodluyoruz.weekFourHomework.service;

import com.kodluyoruz.weekFourHomework.exceptions.errors.NotFoundException;
import com.kodluyoruz.weekFourHomework.model.dto.ProductDto;
import com.kodluyoruz.weekFourHomework.model.entity.Product;
import com.kodluyoruz.weekFourHomework.model.request.CreateUpdateProductRequest;
import com.kodluyoruz.weekFourHomework.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.weekFourHomework.model.mapper.ProductMapper.PRODUCT_MAPPER;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public ProductDto createProduct(CreateUpdateProductRequest request) {
        Product product = PRODUCT_MAPPER.createProduct(request);

        Product savedProduct = repository.save(product);
        return PRODUCT_MAPPER.toProductDto(savedProduct);
    }


    public ProductDto getProduct(int id) {
        Product product = getProductEntity(id);
        return PRODUCT_MAPPER.toProductDto(product);
    }

    private Product getProductEntity(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Product Not Found"));
    }

    public ProductDto updateProduct(int id, CreateUpdateProductRequest request) {
        Product product = getProductEntity(id);
        PRODUCT_MAPPER.updateProduct(product, request);

        Product updatedProduct = repository.save(product);
        return PRODUCT_MAPPER.toProductDto(updatedProduct);
    }

    public List<ProductDto> getProducts(String name) {
        if (name != null) {
            return PRODUCT_MAPPER.toProductDtoList(repository.findAllByNameContainsOrDescriptionContains(name, name));
        }

        return PRODUCT_MAPPER.toProductDtoList(repository.findAll());
    }

    public void deleteProduct(int id) {
        repository.deleteById(id);
    }

    public Boolean checkProduct(int id){
        return repository.findById(id).isPresent();
    }
}
