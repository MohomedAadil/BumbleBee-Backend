package com.example.backendb.controller;

import com.example.backendb.entity.Customer;
import com.example.backendb.entity.Order;
import com.example.backendb.entity.Product;
import com.example.backendb.exception.ResourceNotFoundException;
import com.example.backendb.repository.CustomerRepository;
import com.example.backendb.repository.OrderRepository;
import com.example.backendb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    //Get all orders
    @GetMapping("/Orders")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get an order by id
    @GetMapping("/Orders/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
    }

    // Create a new order
    @PostMapping("/newOrder")
    public Order createOrder(@Valid @RequestBody Order order) {
        // Set customer and product for the order
        Customer customer = customerRepository.findById(order.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + order.getCustomerId()));
        order.setCustomer(customer);
        List<Product> products = new ArrayList<>();
        for (Long productId : order.getProductIds()) {
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + productId));
            products.add(product);
        }
        order.setProducts(products);

        return orderRepository.save(order);
    }

    // Update an order
    @PutMapping("/updateOrder/{id}")
    public Order updateOrder(@PathVariable Long id, @Valid @RequestBody Order orderDetails) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));

        // Update customer and product for the order
        Customer customer = customerRepository.findById(orderDetails.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + orderDetails.getCustomerId()));
        order.setCustomer(customer);
        List<Product> products = new ArrayList<>();
        for (Long productId : orderDetails.getProductIds()) {
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + productId));
            products.add(product);
        }
        order.setProducts(products);

        order.setOrderDate(orderDetails.getOrderDate());
        order.setTotalAmount(orderDetails.getTotalAmount());

        return orderRepository.save(order);
    }

    // Delete an order
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));

        orderRepository.delete(order);

        return ResponseEntity.ok().build();
    }
}
