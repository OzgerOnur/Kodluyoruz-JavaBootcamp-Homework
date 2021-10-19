package com.kodluyoruz.HW3.productAndCategory;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Builder
public class Categorys {

    private final @NonNull String subCategoryName;
    private final @NonNull String mainCategoryName;


}
