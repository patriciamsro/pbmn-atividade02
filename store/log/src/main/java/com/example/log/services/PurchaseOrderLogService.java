package com.example.log.services;

import com.example.log.entities.Action;
import com.example.log.entities.PurchaseOrderLog;
import com.example.log.repositories.PurchaseOrderLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderLogService {

    @Autowired
    private PurchaseOrderLogRepository purchaseOrderLogRepository;

    public List<PurchaseOrderLog> findAll() {
        return purchaseOrderLogRepository.findAll();
    }

    public PurchaseOrderLog findById(String id) {
        return purchaseOrderLogRepository.findById(id).stream().findFirst().orElse(null);
    }

    public List<PurchaseOrderLog> findByAction(Action action) {
        return purchaseOrderLogRepository.findByAction(action.toString());
    }

    public List<PurchaseOrderLog> findByUser(String userName) {
        return purchaseOrderLogRepository.findByUser((userName));
    }

    public PurchaseOrderLog save(PurchaseOrderLog purchaseOrderLog) {
        return purchaseOrderLogRepository.save(purchaseOrderLog);
    }
}