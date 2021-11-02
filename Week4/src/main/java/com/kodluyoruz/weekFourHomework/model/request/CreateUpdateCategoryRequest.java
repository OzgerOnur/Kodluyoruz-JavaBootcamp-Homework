package com.kodluyoruz.weekFourHomework.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateCategoryRequest {
    @NotEmpty(message = "name shouldnt be empty")
    private String name;
    private Integer parentId;
}
