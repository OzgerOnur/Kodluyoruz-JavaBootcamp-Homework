package com.kodluyoruz.weekFourHomework.controller;

import com.kodluyoruz.weekFourHomework.exceptions.errors.UnsuccessfulProcces;
import com.kodluyoruz.weekFourHomework.model.dto.CheckoutDto;
import com.kodluyoruz.weekFourHomework.model.dto.OrderDto;
import com.kodluyoruz.weekFourHomework.model.entity.Order;
import com.kodluyoruz.weekFourHomework.model.request.CheckoutRequest;
import com.kodluyoruz.weekFourHomework.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("checkout")
@RequiredArgsConstructor
public class CheckoutController {
    private final CheckoutService checkoutService;

    @PostMapping()
    public CheckoutDto checkoutBasket(@Valid @RequestBody CheckoutRequest checkoutRequest){
        return checkoutService.checkoutBasket(checkoutRequest);

    }

    @PostMapping("pay")
    public OrderDto payBasket(@Valid @RequestBody CheckoutRequest checkoutRequest) throws UnsuccessfulProcces {
        return checkoutService.pay(checkoutRequest);

    }



}
