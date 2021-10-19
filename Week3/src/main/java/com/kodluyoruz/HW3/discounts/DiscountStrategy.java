package com.kodluyoruz.HW3.discounts;


import com.kodluyoruz.HW3.cartsAndBills.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountStrategy {
    private final List<DiscountMethod>  discountMethodList;

    public void appDiscount(Cart cart){

        for (DiscountMethod dm:discountMethodList) {
            if (dm.checkDiscount(cart)){
                dm.applyDiscount(cart);
                break;
            }
        }



    }

}
