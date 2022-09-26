package com.example.purchaseorder.controllers;

import com.example.purchaseorder.entities.Order;
import com.example.purchaseorder.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable String id) {
        return orderService.findById(id);
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        System.out.println(order.toString());
        return orderService.create(order);
    }

    @PutMapping
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    @DeleteMapping
    public void delete(@RequestBody Order order) {
        orderService.delete(order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        orderService.delete(id);
    }
}
