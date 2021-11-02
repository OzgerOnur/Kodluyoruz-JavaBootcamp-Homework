package com.kodluyoruz.weekFourHomework.service;

import com.kodluyoruz.weekFourHomework.exceptions.errors.UnsuccessfulProcces;
import com.kodluyoruz.weekFourHomework.model.dto.CheckoutDto;
import com.kodluyoruz.weekFourHomework.model.dto.OrderDto;
import com.kodluyoruz.weekFourHomework.model.entity.Basket;
import com.kodluyoruz.weekFourHomework.model.entity.BasketItem;
import com.kodluyoruz.weekFourHomework.model.entity.Order;
import com.kodluyoruz.weekFourHomework.model.request.CheckoutRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.kodluyoruz.weekFourHomework.model.mapper.CheckoutMapper.CHECKOUT_MAPPER;
import static com.kodluyoruz.weekFourHomework.model.mapper.OrderMapper.ORDER_MAPPER;

@Service
@RequiredArgsConstructor
public class CheckoutService {
    private final UserService userService;
    private final OrderService orderService;
    private final BasketService basketService;


    public CheckoutDto checkoutBasket(CheckoutRequest checkoutRequest) {
        Basket basket = userService.getUserEntity(checkoutRequest.getUserId()).getBasket();
        CheckoutDto checkoutDto = getCheckoutDto(basket);
        return checkoutDto;
    }

    private CheckoutDto getCheckoutDto(Basket basket) {
        Double totalPrice = calculatePriceAndDiscounts(basket);
        CheckoutDto checkoutDto = CHECKOUT_MAPPER.basketToCheckout(basket,totalPrice);
        return checkoutDto;
    }


    private double calculatePriceAndDiscounts(Basket basket){
        double total = 0;
        for (BasketItem basketItem : basket.getBasketItems()) {
            total += (double) basketItem.getQuantity() * basketItem.getProduct().getPrice();
        }
        return total;
    }

    public OrderDto pay(CheckoutRequest checkoutRequest) throws UnsuccessfulProcces {
        Basket basket = userService.getUserEntity(checkoutRequest.getUserId()).getBasket();
        if (basket.getBasketItems().isEmpty())
            throw new UnsuccessfulProcces("Empty Basket");
        CheckoutDto checkoutDto = getCheckoutDto(basket);

        Order order;
        if (payservice(checkoutDto)){
            order = orderService.createOrder(basket);
            basketService.removeAllBasketItem(basket.getUserId());
        }
        else {
            throw (new UnsuccessfulProcces());
        }

        return ORDER_MAPPER.orderToOrderDto(order);
    }

    public boolean payservice(CheckoutDto checkoutDto){
        return true;
    }
}
