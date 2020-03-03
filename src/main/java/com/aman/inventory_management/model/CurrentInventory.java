package com.aman.inventory_management.model;

import java.util.List;

public class CurrentInventory {

    private List<IncomingPurchase> incomingPurchaseList;
    private List<OutgoingOrder> outgoingOrderList;

    public CurrentInventory(List<IncomingPurchase> incomingPurchaseList, List<OutgoingOrder> outgoingOrderList) {
        this.incomingPurchaseList = incomingPurchaseList;
        this.outgoingOrderList = outgoingOrderList;
    }

    public List<IncomingPurchase> getIncomingPurchaseList() {
        return incomingPurchaseList;
    }

    public void setIncomingPurchaseList(List<IncomingPurchase> incomingPurchaseList) {
        this.incomingPurchaseList = incomingPurchaseList;
    }

    public List<OutgoingOrder> getOutgoingOrderList() {
        return outgoingOrderList;
    }

    public void setOutgoingOrderList(List<OutgoingOrder> outgoingOrderList) {
        this.outgoingOrderList = outgoingOrderList;
    }
}
