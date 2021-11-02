package com.kodluyoruz.weekFourHomework.model.mapper;

import com.kodluyoruz.weekFourHomework.model.dto.BasketItemDto;
import com.kodluyoruz.weekFourHomework.model.entity.BasketItem;
import com.kodluyoruz.weekFourHomework.model.request.BasketItemRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BasketItemMapper {
    BasketItemMapper ITEM_MAPPER = Mappers.getMapper(BasketItemMapper.class);

    BasketItemDto basketItemToDto(BasketItem basketItem);

    BasketItem requestToItem(BasketItemRequest basketItemRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateItem(@MappingTarget BasketItem basketItem, BasketItemRequest basketItemRequest);

}
