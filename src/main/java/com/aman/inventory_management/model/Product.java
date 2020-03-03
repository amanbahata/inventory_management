package com.aman.inventory_management.model;

public class Product {

//    PRIMARY KEY (`id`)
    private long productId;
    private String productName;
    private String partNumber;
    private String productLabel;
    private int startingInventory;
    private int inventoryReceived;
    private int inventoryShipped;
    private int inventoryOnHand;
    private int minimumRequired;

    public Product(long productId, String productName, String partNumber, String productLabel, int startingInventory,
                   int inventoryReceived, int inventoryShipped, int inventoryOnHand, int minimumRequired) {
        this.productId = productId;
        this.productName = productName;
        this.partNumber = partNumber;
        this.productLabel = productLabel;
        this.startingInventory = startingInventory;
        this.inventoryReceived = inventoryReceived;
        this.inventoryShipped = inventoryShipped;
        this.inventoryOnHand = inventoryOnHand;
        this.minimumRequired = minimumRequired;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getProductLabel() {
        return productLabel;
    }

    public void setProductLabel(String productLabel) {
        this.productLabel = productLabel;
    }

    public int getStartingInventory() {
        return startingInventory;
    }

    public void setStartingInventory(int startingInventory) {
        this.startingInventory = startingInventory;
    }

    public int getInventoryReceived() {
        return inventoryReceived;
    }

    public void setInventoryReceived(int inventoryReceived) {
        this.inventoryReceived = inventoryReceived;
    }

    public int getInventoryShipped() {
        return inventoryShipped;
    }

    public void setInventoryShipped(int inventoryShipped) {
        this.inventoryShipped = inventoryShipped;
    }

    public int getInventoryOnHand() {
        return inventoryOnHand;
    }

    public void setInventoryOnHand(int inventoryOnHand) {
        this.inventoryOnHand = inventoryOnHand;
    }

    public int getMinimumRequired() {
        return minimumRequired;
    }

    public void setMinimumRequired(int minimumRequired) {
        this.minimumRequired = minimumRequired;
    }
}
