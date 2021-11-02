package com.kodluyoruz.weekFourHomework.model.mapper;

import com.kodluyoruz.weekFourHomework.model.dto.ProductDto;
import com.kodluyoruz.weekFourHomework.model.entity.Product;
import com.kodluyoruz.weekFourHomework.model.request.CreateUpdateProductRequest;
import org.mapstruct.*;
import org.mapstruct.control.MappingControl;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductDto toProductDto(Product product);

    List<ProductDto> toProductDtoList(List<Product> products);

    Product createProduct(CreateUpdateProductRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProduct(@MappingTarget Product product, CreateUpdateProductRequest request);
}
