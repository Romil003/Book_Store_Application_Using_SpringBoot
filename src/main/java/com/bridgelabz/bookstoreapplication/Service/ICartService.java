package com.bridgelabz.bookstoreapplication.Service;

import com.bridgelabz.bookstoreapplication.DTO.CartDTO;
import com.bridgelabz.bookstoreapplication.Model.Cart;

import java.util.List;
import java.util.Optional;

public interface ICartService {

    List<Cart> findAllCartItems();

    Optional<Cart> findAllCartItemsForUser(int cartId);

    Cart addToCart(CartDTO cartDTO);

    Cart updateQuantity(int cartId,CartDTO cartDTO);

    void removeFromCart(int cartId);
}
