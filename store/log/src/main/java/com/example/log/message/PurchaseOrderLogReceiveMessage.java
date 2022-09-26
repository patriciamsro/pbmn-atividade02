package com.example.log.message;

import com.example.log.entities.PurchaseOrderLog;
import com.example.log.services.PurchaseOrderLogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PurchaseOrderLogReceiveMessage {

    @Autowired
    private PurchaseOrderLogService purchaseOrderLogService;

    @RabbitListener(queues = {"${store.rabbitmq.purchaseorder.log.queue}"})
    public void receive(@Payload PurchaseOrderLog purchaseOrderLog) {
        purchaseOrderLogService.save(purchaseOrderLog);
    }
}
