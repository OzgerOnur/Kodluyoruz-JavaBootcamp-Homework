package com.kodluyoruz.HW3.discounts;

import com.kodluyoruz.HW3.cartsAndBills.Cart;
import com.kodluyoruz.HW3.cartsAndBills.CartItem;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE+200)
public class Buy2Take3Discount implements DiscountMethod {

    @Override
    public boolean checkDiscount(Cart cart) {

        return true;
    }

    @Override
    public void applyDiscount(Cart cart) {
        for (CartItem ci:cart.getCartItemList()) {
            double newDiscount = ci.getProduct().getPrice() * (ci.getQuantity()/3);
            ci.setDiscounted(newDiscount);

        }
    }
}
