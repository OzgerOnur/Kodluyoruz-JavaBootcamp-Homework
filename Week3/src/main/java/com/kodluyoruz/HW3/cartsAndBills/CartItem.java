package com.kodluyoruz.HW3.cartsAndBills;

import com.kodluyoruz.HW3.productAndCategory.Product;
import lombok.*;

@AllArgsConstructor
@Data
@Builder
public class CartItem {
    private final @NonNull Product product;
    private int quantity;
    private double discounted;

    public double getItemsWithDiscoundedsPrice(){
        return quantity*product.getPrice() - discounted;
    }
    public double getUnitDiscounted(){
        return discounted/quantity;
    }
    public double getItemsWithoutDiscoundPrice(){return quantity*product.getPrice(); }

    @Override
    public String toString() {
        return "Product name:  " + product.getName()
                + " Quantity : " + quantity
                + " description : " + product.getDescription()
                + " Price : " + product.getPrice()
                + " Discounted : " +String.format("%,.2f",getUnitDiscounted())
                + " Total price : " + getItemsWithDiscoundedsPrice()
                ;
    }
}
