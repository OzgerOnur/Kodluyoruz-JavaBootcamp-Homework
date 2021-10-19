package com.kodluyoruz.HW3.discounts;

import com.kodluyoruz.HW3.cartsAndBills.Cart;

public interface DiscountMethod {

    public boolean checkDiscount(Cart cart);
    public void applyDiscount(Cart cart);


}
