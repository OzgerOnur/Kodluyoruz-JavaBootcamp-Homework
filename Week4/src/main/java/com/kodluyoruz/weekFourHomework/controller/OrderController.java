package com.kodluyoruz.weekFourHomework.controller;

import com.kodluyoruz.weekFourHomework.model.dto.OrderDto;
import com.kodluyoruz.weekFourHomework.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("{userId}")
    public List<OrderDto> getOrders(@PathVariable() Integer userId){
        return orderService.getOrders(userId);
    }

    @GetMapping("{userId}/{orderId}")
    public OrderDto getOrder(@PathVariable() Integer userId,@PathVariable() Integer orderId){
        return orderService.getOrder(userId,orderId);
    }


}
