package com.aman.inventory_management.controller;

import com.aman.inventory_management.manage.CurrentInventoryAggregator;
import com.aman.inventory_management.model.CurrentInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrentInventoryResource {

    @Autowired
    private CurrentInventoryAggregator currentInventory;

    @GetMapping("/current-inventory/{productId}")
    public CurrentInventory getCurrentInventory(@PathVariable long productId){
        return currentInventory.getCurrentInventory(productId);
    }
}
