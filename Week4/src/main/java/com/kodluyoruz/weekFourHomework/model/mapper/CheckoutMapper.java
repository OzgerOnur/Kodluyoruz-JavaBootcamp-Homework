package com.kodluyoruz.weekFourHomework.model.mapper;

import com.kodluyoruz.weekFourHomework.model.dto.CheckoutDto;
import com.kodluyoruz.weekFourHomework.model.entity.Basket;
import com.kodluyoruz.weekFourHomework.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface CheckoutMapper {
    CheckoutMapper CHECKOUT_MAPPER = Mappers.getMapper(CheckoutMapper.class);

   CheckoutDto basketToCheckout(Basket basket, Double price);




}
