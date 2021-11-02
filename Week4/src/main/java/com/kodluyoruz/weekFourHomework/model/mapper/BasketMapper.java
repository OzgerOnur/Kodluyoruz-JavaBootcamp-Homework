package com.kodluyoruz.weekFourHomework.model.mapper;

import com.kodluyoruz.weekFourHomework.model.dto.BasketDto;
import com.kodluyoruz.weekFourHomework.model.entity.Basket;

import com.kodluyoruz.weekFourHomework.model.request.AddUpdateBasketRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface BasketMapper {

    BasketMapper BASKET_MAPPER = Mappers.getMapper(BasketMapper.class);


    BasketDto basketToBasketDto(Basket basket);

    Basket requestToBasket(Integer userId, AddUpdateBasketRequest request);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBasket(@MappingTarget Basket basket,AddUpdateBasketRequest request);

}
