package com.kodluyoruz.weekFourHomework.model.request;

import com.kodluyoruz.weekFourHomework.model.entity.Basket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUpdateUserRequest {
    @NotEmpty(message = "name shouldnt be empty")
    private String name;
    @NotEmpty(message = "mail shouldnt be empty")
    private String mail;

}
