package com.springbootacedamyfirst.pointofproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Order {
    @Id
    @Column(name = "order_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date orderDate;

    @Column(name = "total_amount",nullable = false)
    private double totalAmount;

    @OneToMany(mappedBy = "orders")
    private Set<OrderDetail> orderDetail;

    public Order(Customer customer, Date orderDate, double totalAmount) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }
}