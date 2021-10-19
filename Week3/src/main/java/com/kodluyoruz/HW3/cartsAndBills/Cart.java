package com.kodluyoruz.HW3.cartsAndBills;

import com.kodluyoruz.HW3.discounts.DiscountStrategy;
import com.kodluyoruz.HW3.surcharges.DeliveryFee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Cart {
    private final List<CartItem> cartItemList =  new ArrayList<CartItem>();
    //private final List<DiscountMethod> discountMethods;
    private final DiscountStrategy discountStrategy;
    private final DeliveryFee deliveryFee;

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void addCart(CartItem cartItem){
        if(cartItemList.stream().
                anyMatch(p -> p.getProduct().getName().equals(cartItem.getProduct().getName())
                ))
            for (CartItem ci:cartItemList) {
                if (ci.getProduct().getName().equals(cartItem.getProduct().getName())){
                    ci.setQuantity(ci.getQuantity() + cartItem.getQuantity());
                }

            }
        else
            cartItemList.add(cartItem);


    }

    public double cartTotalPrice(){
        double cartTotal = 0;
        double discountTotal = 0;
        for (CartItem ci:cartItemList ) {
            cartTotal = cartTotal + ci.getItemsWithoutDiscoundPrice();
            discountTotal = discountTotal + ci.getDiscounted();

        }
        return cartTotal - discountTotal;
    }
    public double cartTotalPriceWithoutDiscounted(){
        double cartTotal = 0;
        for (CartItem ci:cartItemList ) {
            cartTotal = cartTotal + ci.getItemsWithoutDiscoundPrice();
        }
        return cartTotal;
    }



    private void calculateAndAppDiscount(){

        discountStrategy.appDiscount(this);


    }

    private double calculateDeliveryFee(){
        return deliveryFee.deliveryFeePrice(this);
    }

    public Bill checkOut(){
        String items = "";
        double cartTotal = 0;
        double totalPrice = 0;
        double discountTotal = 0;
        double everyThingsInHere = 0;
        double deliveryFeebill = 0;
        calculateAndAppDiscount();

        for (CartItem ci:cartItemList ) {
            items = items + ci.toString() + "\n";
            totalPrice = totalPrice + ci.getItemsWithoutDiscoundPrice();
            discountTotal = discountTotal + ci.getDiscounted();
        }
        cartTotal = totalPrice - discountTotal;
        deliveryFeebill = calculateDeliveryFee();
        everyThingsInHere = cartTotal + deliveryFeebill;

        return Bill.builder()
                .items(items)
                .cartTotal(cartTotal)
                .discountTotal(discountTotal)
                .everyThingsInHere(everyThingsInHere)
                .deliveryFee(deliveryFeebill)
                .totalPrice(totalPrice)
                .cartItemList(new ArrayList<>(cartItemList))
                .build();

    }




}
