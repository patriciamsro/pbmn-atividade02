package com.example.purchaseorder.message;

import com.example.purchaseorder.entities.Action;
import com.example.purchaseorder.entities.Order;
import com.example.purchaseorder.entities.PurchaseorderLog;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PurchaseorderSendMessageLog {

    @Value("${store.rabbitmq.exchange}")
    String exchange;

    @Value("${store.rabbitmq.log.routingkey}")
    String routingKey;

    @Autowired
    public RabbitTemplate rabbitTemplate;

    public void sendMessage(Order order, Action action) {

        PurchaseorderLog purchaseOrderLog = new PurchaseorderLog();

        purchaseOrderLog.setAction(action);
        purchaseOrderLog.setOrderId(order.getId());
        purchaseOrderLog.setQuantity(order.getQuantity());
        purchaseOrderLog.setDate(order.getDate());
        purchaseOrderLog.setTotalPrice(order.getTotalPrice());
        purchaseOrderLog.setProductName(order.getProduct().getName());
        purchaseOrderLog.setProductCode(order.getProduct().getCode());
        purchaseOrderLog.setManufacture(order.getProduct().getManufacture());
        purchaseOrderLog.setPrice(order.getProduct().getPrice());
        purchaseOrderLog.setUserName(order.getUser().getName());
        purchaseOrderLog.setCpf(order.getUser().getCpf());

        rabbitTemplate.convertAndSend(exchange, routingKey, purchaseOrderLog);
    }
}
