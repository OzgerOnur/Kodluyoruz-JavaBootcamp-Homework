package com.kodluyoruz.weekFourHomework.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "baskets")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Basket extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @OneToOne(fetch = FetchType.LAZY)//,optional = false
    @JoinColumn(name = "user_id",nullable = false,updatable = false, insertable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY,orphanRemoval = true,cascade = CascadeType.ALL)//, mappedBy = "basket"
    private List<BasketItem> basketItems;

}
