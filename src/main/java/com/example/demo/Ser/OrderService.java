package com.example.demo.Ser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Cart;
import com.example.demo.Model.CartItem;
import com.example.demo.Model.Orders;
import com.example.demo.Model.OrderItem;
import com.example.demo.Model.User;
import com.example.demo.Repo.CartItemRepo;
import com.example.demo.Repo.CartRepo;
import com.example.demo.Repo.OrderItemRepo;
import com.example.demo.Repo.OrderRepo;
import com.example.demo.Repo.UserRepo;

@Service
public class OrderService {

    @Autowired private UserRepo userRepo;
    @Autowired private CartRepo cartRepo;
    @Autowired private CartItemRepo cartItemRepo;
    @Autowired private OrderRepo orderRepo;
    @Autowired private OrderItemRepo orderItemRepo;

    public String checkout(Long userId, String address, String paymentMethod) {
        User user = userRepo.findById(userId).orElseThrow();
        Cart cart = user.getCart();

        if (cart == null || cart.getCartitem().isEmpty()) {
            return "Cart is empty!";
        }

        Orders order = new Orders();
        order.setUser(user);
        order.setShippingAddress(address);
        order.setPaymentMethod(paymentMethod);
        order.setOrderTime(LocalDateTime.now());

        double total = 0;
        List<OrderItem> items = new ArrayList<>();

        for (CartItem cartItem : cart.getCartitem()) {
            OrderItem item = new OrderItem();
            item.setMenu(cartItem.getMenu());
            item.setQuantity(cartItem.getQuantity());
            item.setPrice(cartItem.getMenu().getPrice());
            item.setOrder(order);
            items.add(item);
            total += item.getQuantity() * item.getPrice();
        }

        order.setTotalAmount(total);
        order.setOrderItems(items);

        orderRepo.save(order);

       
        cartItemRepo.deleteAll(cart.getCartitem());

        return "Order placed successfully with ID: " + order.getId();
    }
    public List<Orders> getOrdersByRestaurant(Long restaurantId) {
        return orderRepo.findByRestaurantId(restaurantId);
    }

    public List<Orders> getOrdersByStatus(Long restaurantId, String status) {
        return orderRepo.findByRestaurantIdAndStatus(restaurantId, status);
    }

    public Orders updateOrderStatus(Long orderId, String status) {
        Orders order = orderRepo.findById(orderId)
            .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepo.save(order);
    }
}

