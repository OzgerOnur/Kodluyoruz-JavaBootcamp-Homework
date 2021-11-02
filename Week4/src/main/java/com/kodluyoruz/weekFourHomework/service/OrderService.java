package com.kodluyoruz.weekFourHomework.service;

import com.kodluyoruz.weekFourHomework.controller.OrderController;
import com.kodluyoruz.weekFourHomework.exceptions.errors.NotFoundException;
import com.kodluyoruz.weekFourHomework.model.dto.OrderDto;
import com.kodluyoruz.weekFourHomework.model.entity.Basket;
import com.kodluyoruz.weekFourHomework.model.entity.Order;
import com.kodluyoruz.weekFourHomework.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.kodluyoruz.weekFourHomework.model.mapper.OrderMapper.ORDER_MAPPER;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    protected Order createOrder(Basket basket) {
        Order order = ORDER_MAPPER.basketToOrder(basket);
        Order orderDb = orderRepository.save(order);
        orderDb.getOrderItems().stream()
                .forEach(orderItem
                        -> orderItem.setOrderId(orderDb.getId()));
       return orderRepository.save(orderDb);
    }


    public OrderDto getOrder(Integer userId, Integer orderId) {
        Order orderDb = orderRepository.findAllByUserIdEqualsAndIdEquals(userId,orderId)
                .orElseThrow(() -> new NotFoundException("Order Not Found"));
        return ORDER_MAPPER.orderToOrderDto(orderDb);
    }

    public List<OrderDto> getOrders(Integer userId) {
        List<Order> ordersDb = orderRepository.findAllByUserIdEquals(userId)
                .orElseThrow(() -> new NotFoundException("User Not Found"));
        return ORDER_MAPPER.ordersToOrdersDto(ordersDb);
    }
}
