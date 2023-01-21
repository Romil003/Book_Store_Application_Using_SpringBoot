package com.bridgelabz.bookstoreapplication.Service;

import com.bridgelabz.bookstoreapplication.DTO.OrderDTO;
import com.bridgelabz.bookstoreapplication.Exception.OrderException;
import com.bridgelabz.bookstoreapplication.Model.BookModel;
import com.bridgelabz.bookstoreapplication.Model.Order;
import com.bridgelabz.bookstoreapplication.Model.UserLogin;
import com.bridgelabz.bookstoreapplication.Repository.BookModelRepository;
import com.bridgelabz.bookstoreapplication.Repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderService implements IOrderService {

    @Autowired
    private BookModelRepository bookModelRepository;

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private BookModelService bookModelService;

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getAllOrdersForUser(int orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public Order placeOrder(OrderDTO orderDTO) {
        UserLogin userLogin = userLoginService.getUserLoginDataById(orderDTO.userId);
        BookModel bookModel = bookModelService.findBookById(orderDTO.bookId);
        Order order = new Order(orderDTO.orderDate,orderDTO.price,orderDTO.quantity,orderDTO.address,userLogin,bookModel);
        long stock = orderDTO.quantity;
        if(bookModel.getBookQuantity() >= stock){
            long remainingQuantity = bookModel.getBookQuantity() - stock;
            bookModel.setBookQuantity(remainingQuantity);
            orderRepository.save(order);
            return order;
        } else {
            log.info("Quantity not available");
            return null;
        }
    }

    @Override
    public Order cancelOrder(int orderId) {
        Optional<Order> order = this.getAllOrdersForUser(orderId);
        if(order.isPresent()){
            order.get().setCancelOrder(true);
            BookModel bookModel = bookModelService.findBookById(order.get().getBookModel().getId());
            long stock = order.get().getQuantity();
            long updatedQuantity = bookModel.getBookQuantity() + stock;
            bookModel.setBookQuantity(updatedQuantity);
            bookModelRepository.save(bookModel);
            orderRepository.save(order.get());
            log.info("Order cancel successfully !!!");
            return order.get();
        } else {
            log.info("Order not found");
            return null;
        }

    }
}
