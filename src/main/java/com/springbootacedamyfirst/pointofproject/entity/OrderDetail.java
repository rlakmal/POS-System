package com.springbootacedamyfirst.pointofproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "order_detail")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class OrderDetail {

    @Id
    @Column(name = "order_detail_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailId;

    @Column(name = "item_name",length = 100,nullable = false)
    private String itemName;

    @Column(name = "qty",length = 50,nullable = false)
    private double qty;

    @Column(name = "amount",nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item items;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order orders;







}
