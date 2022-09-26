package com.example.purchaseorder.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseorderLog {

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
