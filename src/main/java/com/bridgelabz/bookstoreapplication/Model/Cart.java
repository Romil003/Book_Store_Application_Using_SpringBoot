package com.bridgelabz.bookstoreapplication.Model;

import com.bridgelabz.bookstoreapplication.DTO.CartDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "UserCartTable")
@Data
public class Cart {

    @Id
    @GeneratedValue
    private int cartId;

    @JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserLogin userLogin;

    @JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id")
    private BookModel bookModel;

    private long quantity;

    private long totalPrice;

    public Cart() {
    }

    public Cart(UserLogin userLogin, BookModel bookModel, long quantity, long totalPrice) {
        this.userLogin = userLogin;
        this.bookModel = bookModel;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Cart(CartDTO cartDTO){
        this.quantity = cartDTO.quantity;
        this.totalPrice = cartDTO.totalPrice;
    }
}
