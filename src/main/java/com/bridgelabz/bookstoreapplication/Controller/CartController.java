package com.bridgelabz.bookstoreapplication.Controller;

import com.bridgelabz.bookstoreapplication.DTO.BookModelDTO;
import com.bridgelabz.bookstoreapplication.DTO.CartDTO;
import com.bridgelabz.bookstoreapplication.DTO.ResponseDTO;
import com.bridgelabz.bookstoreapplication.Model.BookModel;
import com.bridgelabz.bookstoreapplication.Model.Cart;
import com.bridgelabz.bookstoreapplication.Service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService iCartService;

    @GetMapping("/allCartItems")
    public ResponseEntity<ResponseDTO> getAllCartItems(){
        List<Cart> cartItemsList = iCartService.findAllCartItems();
        ResponseDTO responseDTO = new ResponseDTO("Getting cart items => ",cartItemsList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getbyId/{cartId}")
    public ResponseEntity<ResponseDTO> getAllCartItemsById(@PathVariable int cartId){
        Optional<Cart> cart = iCartService.findAllCartItemsForUser(cartId);
        ResponseDTO responseDTO = new ResponseDTO("Get all cart data of cartId : "+cartId,cart);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/addDataToCart")
    public ResponseEntity<ResponseDTO> addToCart(@Valid @RequestBody CartDTO cartDTO){
        Cart cart = iCartService.addToCart(cartDTO);
        ResponseDTO responseDTO = new ResponseDTO("Creating cart data : ",cart);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/editCartData/{cartId}")
    public ResponseEntity<ResponseDTO> editBookData(@PathVariable int cartId,@Valid @RequestBody CartDTO cartDTO){
        Cart cart = iCartService.updateQuantity(cartId,cartDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updating cart data : ",cart);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

    }

    @DeleteMapping("/deleteCartDataById/{Id}")
    public ResponseEntity<ResponseDTO> removeFromCartById(@PathVariable int cartId){
        iCartService.removeFromCart(cartId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted successfully !!!");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
