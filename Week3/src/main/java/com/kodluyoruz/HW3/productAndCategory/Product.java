package com.kodluyoruz.HW3.productAndCategory;



import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;



@Getter
@Builder
public class Product {
    private final @NonNull String name;
    private final @NonNull String description;
    private final double  price;
    private final @NonNull Categorys categorys;


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description: '" + description + '\'' +
                ", price=" + price +
                '}'+"\n";
    }
}
