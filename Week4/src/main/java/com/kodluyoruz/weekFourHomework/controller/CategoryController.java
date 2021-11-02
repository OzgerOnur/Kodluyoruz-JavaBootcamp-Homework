package com.kodluyoruz.weekFourHomework.controller;

import com.kodluyoruz.weekFourHomework.model.dto.CategoryDto;
import com.kodluyoruz.weekFourHomework.model.dto.ProductDto;
import com.kodluyoruz.weekFourHomework.model.request.CreateUpdateCategoryRequest;
import com.kodluyoruz.weekFourHomework.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDto createCategory(@Valid @RequestBody CreateUpdateCategoryRequest request){
        return service.createCategory(request);
    }

    @GetMapping
    public List<CategoryDto> getCategories(){
        return service.getCategories();
    }

    @GetMapping("{id}/parent")
    public CategoryDto getParentCategory(@PathVariable int id){
        return service.getParentCategory(id);
    }

    @PatchMapping("{id}")
    public CategoryDto updateCategory(@PathVariable int id,@Valid @RequestBody CreateUpdateCategoryRequest request) {
        return service.updateCategory(id, request);
    }

    @GetMapping("{id}/subcategories")
    public List<CategoryDto> getSubCategory(@PathVariable int id){
        return service.getSubCategory(id);
    }

    @GetMapping("{id}/products")
    public List<ProductDto> getCategoryProducts(@PathVariable int id) {
        return service.getCategoryProducts(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id){
        service.deleteCategory(id);
    }
}
