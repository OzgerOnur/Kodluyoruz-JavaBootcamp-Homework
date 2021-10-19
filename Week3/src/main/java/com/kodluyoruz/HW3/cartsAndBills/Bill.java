package com.kodluyoruz.HW3.cartsAndBills;

import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Builder
@Getter
public class Bill {
    private final double cartTotal;
    private final double discountTotal;
    private final double totalPrice;
    private final double deliveryFee;
    private final double everyThingsInHere;
    private final List<CartItem> cartItemList;
    private final String items;





    @Override
    public String toString() {


        return "items :\n" + items
                +"\nTotal Price: "+ totalPrice
                +"\nDiscountTotal: "+ discountTotal
                +"\nCartTotal: "+ cartTotal
                +"\nDeliveryFee: " + deliveryFee
                +"\n Total Amont: " + everyThingsInHere;
    }
}
