package com.kodluyoruz.weekFourHomework.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUpdateProductRequest {
    @NotEmpty(message = "name shouldnt be empty")
    private String name;
    private String description;
    @NotEmpty(message = "price shouldnt be empty")
    private Double price;
    @NotEmpty(message = "categoryId shouldnt be empty")
    private Integer categoryId;
}
