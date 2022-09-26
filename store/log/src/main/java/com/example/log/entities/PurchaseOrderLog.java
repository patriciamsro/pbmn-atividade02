package com.example.log.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "purchase_order_log")
public class PurchaseOrderLog {

    @Id
    private String id;

    private Action action = Action.NONE;
    private String orderId;
    private Integer quantity;
    private Date date;
    private Double totalPrice;
    private String productName;
    private Integer productCode;
    private String manufacture;
    private Double price;
    private String userName;
    private String cpf;
}
