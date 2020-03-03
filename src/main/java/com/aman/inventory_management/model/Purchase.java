package com.aman.inventory_management.model;

import java.time.LocalDate;
import java.util.Date;

public class Purchase {

    private long purchaseId;
    private long supplierId;
    private long productId;
    private int numberReceived;
    private LocalDate purchaseDate;

    public Purchase(long purchaseId, long supplierId, long productId, int numberReceived, LocalDate purchaseDate) {
        this.purchaseId = purchaseId;
        this.supplierId = supplierId;
        this.productId = productId;
        this.numberReceived = numberReceived;
        this.purchaseDate = purchaseDate;
    }

    public java.lang.Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(java.lang.Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public java.lang.Long getSupplierId() {
        return supplierId;
    }

    public void setSupplier(long supplierId) {
        this.supplierId = supplierId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProduct(long productId) {
        this.productId = productId;
    }

    public int getNumberReceived() {
        return numberReceived;
    }

    public void setNumberReceived(int numberReceived) {
        this.numberReceived = numberReceived;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
