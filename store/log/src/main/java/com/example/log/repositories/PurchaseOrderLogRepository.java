package com.example.log.repositories;

import com.example.log.entities.PurchaseOrderLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrderLogRepository extends MongoRepository<PurchaseOrderLog, String> {

    @Query("{action: ?0}")
    public List<PurchaseOrderLog> findByAction(String action);

    @Query("{userName: ?0}")
    public List<PurchaseOrderLog> findByUser(String userName);
}
