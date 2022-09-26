package com.example.log.controllers;

import com.example.log.entities.Action;
import com.example.log.entities.PurchaseOrderLog;
import com.example.log.services.PurchaseOrderLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class PurchaseOrderLogController {


    @Autowired
    private PurchaseOrderLogService purchaseOrderLogService;

    @GetMapping
    public List<PurchaseOrderLog> findAll() {
        return purchaseOrderLogService.findAll();
    }

    @GetMapping("/id/{id}")
    public PurchaseOrderLog findById(@PathVariable String id) {
        return purchaseOrderLogService.findById(id);
    }

    @GetMapping("/action/{action}")
    public List<PurchaseOrderLog> findByAction(@PathVariable Action action) {
        return purchaseOrderLogService.findByAction(action);
    }

    @GetMapping("/user/{user}")
    public List<PurchaseOrderLog> findByUser(@PathVariable String user) {
        return purchaseOrderLogService.findByUser(user);
    }
}
