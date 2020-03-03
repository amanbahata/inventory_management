package com.aman.inventory_management.model;

import java.time.LocalDate;

public class IncomingPurchase {

    private long productId;
    private LocalDate purchaseDate;
    private String productLabel;
    private int numberReceived;
    private String supplierName;

    public IncomingPurchase(long productId, LocalDate purchaseDate, String productLabel, int numberReceived, String supplierName) {
        this.productId = productId;
        this.purchaseDate = purchaseDate;
        this.productLabel = productLabel;
        this.numberReceived = numberReceived;
        this.supplierName = supplierName;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getProductLabel() {
        return productLabel;
    }

    public void setProductLabel(String productLabel) {
        this.productLabel = productLabel;
    }

    public int getNumberReceived() {
        return numberReceived;
    }

    public void setNumberReceived(int numberReceived) {
        this.numberReceived = numberReceived;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
