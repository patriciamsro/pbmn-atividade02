package com.example.purchaseorder.services;

import com.example.purchaseorder.entities.Action;
import com.example.purchaseorder.entities.Order;
import com.example.purchaseorder.message.PurchaseorderSendMessageLog;
import com.example.purchaseorder.repositories.OrderRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    PurchaseorderSendMessageLog purchaseorderSendMessageLog;

    public Order findById(String id) {
        var order = orderRepository.findById(id).stream().findFirst().orElse(null);
        return order;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order create(Order order) {
        order.SumTotalPrice();

        var newOrder = orderRepository.save(order);
        purchaseorderSendMessageLog.sendMessage(newOrder, Action.ADD);
        return newOrder;
    }

    public Order update(Order order) {
        if(order != null && order.getId().isEmpty()) {
            var dbOrder = findById(order.getId());

            if(dbOrder != null) {
                order.SumTotalPrice();
                var newOrder = orderRepository.save(order);
                purchaseorderSendMessageLog.sendMessage(newOrder, Action.UPDATE);
                return newOrder;
            }
        }
        return null;
    }

    public void delete(Order order) {
        if(order != null && order.getId().isEmpty()) {
            purchaseorderSendMessageLog.sendMessage(order, Action.REMOVE);
            orderRepository.delete(order);
        }
    }

    public void delete(@NotNull String id) {
        if(!id.isEmpty()) {
            var order = findById(id);

            if(order != null) {
                purchaseorderSendMessageLog.sendMessage(order, Action.REMOVE);
                orderRepository.deleteById(id);
            }
        }
    }
}
