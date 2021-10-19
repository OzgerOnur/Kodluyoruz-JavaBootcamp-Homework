package com.kodluyoruz.HW3.discounts;

import com.kodluyoruz.HW3.cartsAndBills.Cart;
import com.kodluyoruz.HW3.cartsAndBills.CartItem;
import com.kodluyoruz.HW3.properties.DiscountProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE+100)
public class PercentageDiscount implements DiscountMethod {
    private final DiscountProperties discountProperties;

    @Override
    public boolean checkDiscount(Cart cart) {
        if (cart.cartTotalPriceWithoutDiscounted() >= 1000)
            return true;
        return false;
    }

    @Override
    public void applyDiscount(Cart cart) {
        for (CartItem ci:cart.getCartItemList()) {
            double newDiscount = ci.getItemsWithoutDiscoundPrice() * (discountProperties.getPercentage()/100);
            ci.setDiscounted(newDiscount);

        }

    }
}
