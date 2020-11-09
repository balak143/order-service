package com.ms.login.models;

import java.util.Date;
import java.util.List;

public class Order {
    private String orderId;
    private Date orderDate;
    private Double totalAmount = 0.0;
    private List<Item> items ;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotalAmount() {
        //items.forEach(item -> totalAmount+=item.getAmount());
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount=totalAmount;
    }



    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }


}
