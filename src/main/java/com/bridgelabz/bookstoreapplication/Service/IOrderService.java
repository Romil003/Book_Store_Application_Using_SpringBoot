package com.bridgelabz.bookstoreapplication.Service;

import com.bridgelabz.bookstoreapplication.DTO.OrderDTO;
import com.bridgelabz.bookstoreapplication.Model.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.Optional;

public interface IOrderService {

    List<Order> getAllOrders();

    Optional<Order> getAllOrdersForUser(int orderId);

    Order placeOrder(OrderDTO orderDTO);

    Order cancelOrder(int orderId);
}
