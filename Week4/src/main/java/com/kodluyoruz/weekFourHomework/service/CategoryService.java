package com.kodluyoruz.weekFourHomework.service;

import com.kodluyoruz.weekFourHomework.exceptions.errors.NotFoundException;
import com.kodluyoruz.weekFourHomework.model.dto.CategoryDto;
import com.kodluyoruz.weekFourHomework.model.dto.ProductDto;
import com.kodluyoruz.weekFourHomework.model.entity.Category;
import com.kodluyoruz.weekFourHomework.model.entity.Product;
import com.kodluyoruz.weekFourHomework.model.request.CreateUpdateCategoryRequest;
import com.kodluyoruz.weekFourHomework.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.weekFourHomework.model.mapper.CategoryMapper.CATEGORY_MAPPER;
import static com.kodluyoruz.weekFourHomework.model.mapper.ProductMapper.PRODUCT_MAPPER;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryDto createCategory(CreateUpdateCategoryRequest request) {
        Category category = CATEGORY_MAPPER.createCategory(request);
        Category newCategory = repository.save(category);

        return CATEGORY_MAPPER.toCategoryDto(newCategory);
    }

    public List<CategoryDto> getCategories() {
        return CATEGORY_MAPPER.toCategoryDtoList(repository.findAll());
    }

    public CategoryDto getParentCategory(int id) {
        Category category = repository.findById(id).orElseThrow(() -> new NotFoundException());
        return CATEGORY_MAPPER.toCategoryDto(category.getParentCategory());
    }

    public List<ProductDto> getCategoryProducts(int id) {
        Category category = repository.findById(id).orElseThrow(() -> new NotFoundException());
        return PRODUCT_MAPPER.toProductDtoList(category.getProducts());
    }

    public List<CategoryDto> getSubCategory(int id) {
        Category category = repository.findById(id).orElseThrow(() -> new NotFoundException());
        return CATEGORY_MAPPER.toCategoryDtoList(category.getSubCategoryList());
    }

    public CategoryDto updateCategory(int id, CreateUpdateCategoryRequest request) {
        Category category = getCategoryEntity(id);
        CATEGORY_MAPPER.updateCategory(category, request);

        Category updatedCategory = repository.save(category);
        return CATEGORY_MAPPER.toCategoryDto(updatedCategory);
    }

    private Category getCategoryEntity(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public void deleteCategory(int id) {
        repository.deleteById(id);
    }
}
