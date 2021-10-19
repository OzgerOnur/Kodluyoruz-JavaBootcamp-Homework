package com.kodluyoruz.HW3.surcharges;

import com.kodluyoruz.HW3.cartsAndBills.Cart;
import com.kodluyoruz.HW3.properties.DeliveryFeeProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class DeliveryFee {
    private DeliveryFeeProperties deliveryFeeProperties;

    public double deliveryFeePrice(Cart cart){
        if(cart.cartTotalPrice() >= deliveryFeeProperties.getDeliveryFeeLimit())
            return 0;
        else
            return deliveryFeeProperties.getDeliveryFee();

    }


}
