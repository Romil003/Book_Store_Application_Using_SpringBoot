package com.bridgelabz.bookstoreapplication.Service;

import com.bridgelabz.bookstoreapplication.DTO.CartDTO;
import com.bridgelabz.bookstoreapplication.Model.BookModel;
import com.bridgelabz.bookstoreapplication.Model.Cart;
import com.bridgelabz.bookstoreapplication.Model.UserLogin;
import com.bridgelabz.bookstoreapplication.Repository.CartModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CartService implements ICartService {

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private BookModelService bookModelService;

    @Autowired
    private CartModelRepository cartRepository;

    @Override
    public List<Cart> findAllCartItems() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findAllCartItemsForUser(int cartId) {
        return cartRepository.findById(cartId);
    }

    @Override
    public Cart addToCart(CartDTO cartDTO) {
        UserLogin userLogin = userLoginService.getUserLoginDataById(cartDTO.userId);
        BookModel bookModel = bookModelService.findBookById(cartDTO.bookId);
        Cart cart = new Cart(userLogin,bookModel,cartDTO.quantity,cartDTO.totalPrice);
        cartRepository.save(cart);
        log.info("Added to cart successfully !!!");
        return cart;
    }

    @Override
    public Cart updateQuantity(int cartId,CartDTO cartDTO) {
        Optional<Cart> cart = this.findAllCartItemsForUser(cartId);
        if(cart != null){
            cart.get().setQuantity(cartDTO.quantity);
            cartRepository.save(cart.get());
            return cart.get();
        } else {
            return null;
        }
    }

    @Override
    public void removeFromCart(int cartId) {
        cartRepository.deleteById(cartId);
        log.info("Remove from cart successfully !!!");
    }
}
