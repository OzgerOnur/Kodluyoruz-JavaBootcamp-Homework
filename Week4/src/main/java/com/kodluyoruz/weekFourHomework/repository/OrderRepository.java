package com.kodluyoruz.weekFourHomework.repository;

import com.kodluyoruz.weekFourHomework.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    Optional<List<Order>> findAllByUserIdEquals(Integer userId);

    Optional<Order> findAllByUserIdEqualsAndIdEquals(Integer userId, Integer orderId);

}
