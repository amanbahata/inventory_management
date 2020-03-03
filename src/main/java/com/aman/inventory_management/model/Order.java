package com.aman.inventory_management.model;

import java.time.LocalDate;

public class Order {

//    PRIMARY KEY (`id`),
    private int orderId;
    private String title;
    private String first;
    private String middle;
    private String last;
    private long productId;
    private int numberShipped;
    private LocalDate orderDate;

    public Order(int orderId, String title, String first, String middle, String last,
                 long productId, int numberShipped, LocalDate orderDate) {
        this.orderId = orderId;
        this.title = title;
        this.first = first;
        this.middle = middle;
        this.last = last;
        this.productId = productId;
        this.numberShipped = numberShipped;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getNumberShipped() {
        return numberShipped;
    }

    public void setNumberShipped(int numberShipped) {
        this.numberShipped = numberShipped;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
