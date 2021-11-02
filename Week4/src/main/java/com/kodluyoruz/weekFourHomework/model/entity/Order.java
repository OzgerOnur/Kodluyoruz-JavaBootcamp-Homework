package com.kodluyoruz.weekFourHomework.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY)//,optional = false
    @JoinColumn(name = "user_id",updatable = false,insertable = false,nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY,mappedBy ="order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;


    @Column(name = "price")
    private Double totalPrice;



}
