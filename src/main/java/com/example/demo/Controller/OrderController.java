package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Orders;
import com.example.demo.Ser.OrderService;
@RequestMapping("/user")
@RestController
public class OrderController {

    @Autowired private OrderService orderService;

    @PostMapping("/checkout/{userId}/{address}/{paymentMethod}")
    public String checkout(@PathVariable Long userId,
                           @PathVariable String address,
                           @PathVariable String paymentMethod) {
        return orderService.checkout(userId, address, paymentMethod);
    }
    
 // All orders for restaurant
    @GetMapping("/allorders/{restaurantId}")
    public List<Orders> getAllOrders(@PathVariable Long restaurantId) {
        return orderService.getOrdersByRestaurant(restaurantId);
    }

    // Filtered by status (e.g., Pending, Delivered)
    @GetMapping("/statusorder/{restaurantId}/{status}")
    public List<Orders> getOrdersByStatus(@PathVariable Long restaurantId, @PathVariable String status) {
        return orderService.getOrdersByStatus(restaurantId, status);
    }

    // Update order status
    @PutMapping("/update-statusorder/{orderId}/{status}")
    public ResponseEntity<Orders> updateStatus(@PathVariable Long orderId, @PathVariable String status) {
        return ResponseEntity.ok(orderService.updateOrderStatus(orderId, status));
    }
}
