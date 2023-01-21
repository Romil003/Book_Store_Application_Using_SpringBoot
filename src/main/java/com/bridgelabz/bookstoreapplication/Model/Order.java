package com.bridgelabz.bookstoreapplication.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "OrderTable")
@Data
public class Order {

    @Id
    @GeneratedValue
    private int orderId;

    @Column(name = "Order_date")
    private LocalDate orderDate;

    @Column(name = "Order_Price")
    private long price;

    @Column(name = "Order_quantity")
    private long quantity;

    @Column(name = "delivery_address")
    private String address;

    @JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserLogin userLogin;

    @JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id")
    private BookModel bookModel;

    @Column(name = "Cancel_Order")
    private boolean cancelOrder = false;

    public Order() {
    }

    public Order(LocalDate orderDate, long price, long quantity, String address, UserLogin userLogin, BookModel bookModel) {
        this.orderDate = orderDate;
        this.price = price;
        this.quantity = quantity;
        this.address = address;
        this.userLogin = userLogin;
        this.bookModel = bookModel;
    }
}
