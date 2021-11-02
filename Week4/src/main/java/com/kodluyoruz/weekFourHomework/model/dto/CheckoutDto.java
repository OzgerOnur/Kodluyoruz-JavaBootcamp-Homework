package com.kodluyoruz.weekFourHomework.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutDto {
    private Integer Id;
    private Integer userId;
    private List<BasketItemDto> basketItems;
    private Double price;

}
