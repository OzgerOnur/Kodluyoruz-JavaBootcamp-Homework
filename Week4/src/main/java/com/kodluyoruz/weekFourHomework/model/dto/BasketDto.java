package com.kodluyoruz.weekFourHomework.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketDto {
    private Integer id;
    private Integer userId;
    private List<BasketItemDto> basketItems;

}
