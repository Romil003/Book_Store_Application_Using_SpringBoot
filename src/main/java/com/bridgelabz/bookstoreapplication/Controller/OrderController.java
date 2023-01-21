package com.bridgelabz.bookstoreapplication.Controller;

import com.bridgelabz.bookstoreapplication.DTO.CartDTO;
import com.bridgelabz.bookstoreapplication.DTO.OrderDTO;
import com.bridgelabz.bookstoreapplication.DTO.ResponseDTO;
import com.bridgelabz.bookstoreapplication.Model.Cart;
import com.bridgelabz.bookstoreapplication.Model.Order;
import com.bridgelabz.bookstoreapplication.Service.IOrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService iOrderService;

    @GetMapping("/allOrderItems")
    public ResponseEntity<ResponseDTO> getAllCartItems(){
        List<Order> ordersItemsList = iOrderService.getAllOrders();
        ResponseDTO responseDTO = new ResponseDTO("Getting all order items => ",ordersItemsList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getOrderItembyId/{orderId}")
    public ResponseEntity<ResponseDTO> getAllOrderItemsForUserById(@PathVariable int orderId){
        Optional<Order> order = iOrderService.getAllOrdersForUser(orderId);
        ResponseDTO responseDTO = new ResponseDTO("Getting all order data of orderId : "+orderId,order);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/createOrder")
    public ResponseEntity<ResponseDTO> placeOrder(@Valid @RequestBody OrderDTO orderDTO){
        Order order = iOrderService.placeOrder(orderDTO);
        ResponseDTO responseDTO = new ResponseDTO("Placing order for user data : ",order);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/cancelOrder/{orderId}")
    public ResponseEntity<ResponseDTO> editBookData(@PathVariable int orderId){
        Order order = iOrderService.cancelOrder(orderId);
        ResponseDTO responseDTO = new ResponseDTO("Cancelling order : ",order);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

    }

}
