package com.kodluyoruz.weekFourHomework.model.mapper;

import com.kodluyoruz.weekFourHomework.model.dto.OrderDto;
import com.kodluyoruz.weekFourHomework.model.dto.OrderItemDto;
import com.kodluyoruz.weekFourHomework.model.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper ORDER_MAPPER = Mappers.getMapper(OrderMapper.class);


    @Mapping(target = "creationDate",ignore = true)
    @Mapping(target = "lastModificationDate",ignore = true)
    @Mapping(target = "deleted",ignore = true)
    @Mapping(target = "id",ignore = true)
    @Mapping(source = "basketItems",target = "orderItems",qualifiedByName = "basketItemTOrderItem")
    @Mapping(source = "basketItems",target = "totalPrice",qualifiedByName = "basketToPrice")
    Order basketToOrder(Basket basket);

    @Named("basketToPrice")
    static Double basketToPrice(List<BasketItem> basketItems){
        return basketItems.stream()
                .mapToDouble(value -> value.getProduct().getPrice())
                .sum();
    }


    @Mapping(target = "creationDate",ignore = true)
    @Mapping(target = "lastModificationDate",ignore = true)
    @Mapping(target = "deleted",ignore = true)
    @Mapping(target = "id",ignore = true)
    @Named("basketItemTOrderItem")
    @Mapping(target ="price",source = "product",qualifiedByName = "productToPrice")
    OrderItem basketItemTOrderItem(BasketItem basketItem);

    @Named("productToPrice")
    static Double productToPrice(Product product){
        return product.getPrice();
    }



    OrderDto orderToOrderDto(Order order);

    List<OrderDto> ordersToOrdersDto(List<Order> orders);

    OrderItemDto orderItemToOrderItemDto(OrderItem orderItem);
}
