package com.kodluyoruz.weekFourHomework.controller;

import com.kodluyoruz.weekFourHomework.model.dto.ProductDto;
import com.kodluyoruz.weekFourHomework.model.request.CreateUpdateProductRequest;
import com.kodluyoruz.weekFourHomework.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto createProduct(@Valid @RequestBody CreateUpdateProductRequest request) {
        return service.createProduct(request);
    }

    @GetMapping("{id}")
    public ProductDto getProduct(@PathVariable int id) {
        return service.getProduct(id);
    }

    @PatchMapping("{id}")
    public ProductDto updateProduct(@PathVariable int id,@Valid @RequestBody CreateUpdateProductRequest request) {
        return service.updateProduct(id, request);
    }

    @GetMapping
    public List<ProductDto> getProducts(@RequestParam(required = false) String name) {
        return service.getProducts(name);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
    }


}
