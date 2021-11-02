package com.kodluyoruz.weekFourHomework.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private Integer id;
    private Integer quantity;
    private Integer productId;
    private Double price;
}


