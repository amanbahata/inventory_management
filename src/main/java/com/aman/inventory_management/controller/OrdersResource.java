package com.aman.inventory_management.controller;

import com.aman.inventory_management.exception.OrderNotFoundException;
import com.aman.inventory_management.exception.PurchaseNotFoundException;
import com.aman.inventory_management.model.Order;
import com.aman.inventory_management.model.Purchase;
import com.aman.inventory_management.repository.OrderDaoService;
import com.aman.inventory_management.repository.PurchaseDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersResource {

        @Autowired
        private OrderDaoService service;

        @GetMapping
        List<Order> retrieveAllOrders(){
            return service.findAll();
        }

        @PostMapping
        Order retrieveOrder(@RequestBody Order order){
            return service.save(order);
        }

        @DeleteMapping("/{id}")
        Order deleteOrder(@PathVariable long id){
            Order order = service.deleteById(id);
            if (order == null){
                throw new OrderNotFoundException("id - " + id);
            }
            return order;
        }

        @PutMapping("/{id}")
        Order updatePurchase(@RequestBody Order order, @PathVariable long id){
            Order updatedOrder = service.updateById(order, id);
            if (order == null){
                throw new OrderNotFoundException("id - " + id);
            }
            return updatedOrder;
        }

}
