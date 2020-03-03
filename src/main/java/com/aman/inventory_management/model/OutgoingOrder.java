package com.aman.inventory_management.model;

import java.time.LocalDate;

public class OutgoingOrder {

    private long orderId;
    private LocalDate orderDate;
    private String productLabel;
    private int numberShipped;
    private String clientFirstName;
    private String clientLastName;

    public OutgoingOrder(long orderId, LocalDate orderDate, String productLabel, int numberShipped, String clientFirstName, String clientLastName) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.productLabel = productLabel;
        this.numberShipped = numberShipped;
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getProductLabel() {
        return productLabel;
    }

    public void setProductLabel(String productLabel) {
        this.productLabel = productLabel;
    }

    public int getNumberShipped() {
        return numberShipped;
    }

    public void setNumberShipped(int numberShipped) {
        this.numberShipped = numberShipped;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }
}
