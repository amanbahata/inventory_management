package com.aman.inventory_management.controller;

import com.aman.inventory_management.exception.PurchaseNotFoundException;
import com.aman.inventory_management.manage.CurrentInventoryAggregator;
import com.aman.inventory_management.model.IncomingPurchase;
import com.aman.inventory_management.model.Purchase;
import com.aman.inventory_management.repository.PurchaseDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incoming-purchases")
public class PurchaseResource {

        @Autowired
        private PurchaseDaoService service;
        @Autowired
        private CurrentInventoryAggregator inventoryAggregator;

        @GetMapping
        List<IncomingPurchase> retrieveAllPurchases(){
            return inventoryAggregator.aggregateIncomingPurchases();
        }

        @PostMapping
        Purchase savePurchase(@RequestBody Purchase purchase){
            return service.save(purchase);
        }

        @DeleteMapping("/{id}")
        Purchase deletePurchase(@PathVariable long id){
            Purchase purchase = service.deleteById(id);
            if (purchase == null){
                throw new PurchaseNotFoundException("id - " + id);
            }
            return purchase;
        }

        @PutMapping("/{id}")
        Purchase updatePurchase(@RequestBody Purchase purchase, @PathVariable long id){
            Purchase updatedPurchase = service.updateById(purchase, id);
            if (purchase == null){
                throw new PurchaseNotFoundException("id - " + id);
            }
            return updatedPurchase;
        }

}
