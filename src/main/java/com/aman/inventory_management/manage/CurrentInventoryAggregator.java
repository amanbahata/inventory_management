package com.aman.inventory_management.manage;

import com.aman.inventory_management.model.*;
import com.aman.inventory_management.repository.OrderDaoService;
import com.aman.inventory_management.repository.ProductDaoService;
import com.aman.inventory_management.repository.PurchaseDaoService;
import com.aman.inventory_management.repository.SupplierDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class CurrentInventoryAggregator {

    @Autowired
    private PurchaseDaoService purchaseService;
    @Autowired
    private OrderDaoService orderService;
    @Autowired
    private ProductDaoService productService;
    @Autowired
    private SupplierDaoService supplierService;

    public CurrentInventory getCurrentInventory(long productId){
        List<IncomingPurchase> incomingPurchaseList = aggregateIncomingPurchasesById(productId);
        List<OutgoingOrder> outgoingOrderList = aggregateOutgoingOrders(productId);
        return new CurrentInventory(incomingPurchaseList, outgoingOrderList);
    }

    public List<IncomingPurchase> aggregateIncomingPurchases(){

        List<Purchase> purchaseList = purchaseService.findAll();

        return purchaseList.stream()
                .map(elem -> {
                    Supplier supplier = supplierService.findOne(elem.getSupplierId());
                    Product product = productService.findOne(elem.getProductId());
                    return new IncomingPurchase(product.getProductId(),elem.getPurchaseDate(), product.getProductLabel(), elem.getNumberReceived(), supplier.getSupplierName());
                })
                .collect(Collectors.toList());
    }

    public List<IncomingPurchase> aggregateIncomingPurchasesById(long productId){
        Predicate<Purchase> predicate = new Predicate<Purchase>() {
            @Override
            public boolean test(Purchase purchase) {
                return purchase.getProductId() == productId;
            }
        };

        List<Purchase> purchaseList = purchaseService.findAll()
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());

        return purchaseList.stream()
                .map(elem -> {
                    Supplier supplier = supplierService.findOne(elem.getSupplierId());
                    Product product = productService.findOne(elem.getProductId());
                    return new IncomingPurchase(product.getProductId(),elem.getPurchaseDate(), product.getProductLabel(), elem.getNumberReceived(), supplier.getSupplierName());
                })
                .collect(Collectors.toList());
    }

    public List<OutgoingOrder> aggregateOutgoingOrders(long id) {
        Predicate<Order> predicate = new Predicate<Order>() {
            @Override
            public boolean test(Order order) {
                return order.getProductId() == id;
            }
        };

        List<Order> orderList = orderService.findAll()
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());


        return orderList.stream()
            .map(elem -> {
                Product product = productService.findOne(elem.getProductId());
                return new OutgoingOrder(elem.getOrderId(), elem.getOrderDate(), product.getProductLabel(), elem.getNumberShipped(), elem.getFirst(), elem.getLast());
            }).collect(Collectors.toList());
    }
}
