package com.ms.login.models;

public class Item {

    private Integer productId;
    private Integer quantity;
    private Double price;


    private Double amount;


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return this.price * this.quantity;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
