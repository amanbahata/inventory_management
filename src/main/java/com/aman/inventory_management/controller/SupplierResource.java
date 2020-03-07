package com.aman.inventory_management.controller;

import com.aman.inventory_management.exception.OrderNotFoundException;
import com.aman.inventory_management.model.Order;
import com.aman.inventory_management.model.Supplier;
import com.aman.inventory_management.repository.OrderDaoService;
import com.aman.inventory_management.repository.SupplierDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierResource {

        @Autowired
        private SupplierDaoService service;

        @GetMapping
        List<Supplier> retrieveAllSuppliers(){
            return service.findAll();
        }

        @PostMapping
        Supplier saveSupplier(@RequestBody Supplier supplier){
            return service.save(supplier);
        }

        @DeleteMapping("/{id}")
        Supplier deleteSupplier(@PathVariable long id){
            Supplier order = service.deleteById(id);
            if (order == null){
                throw new OrderNotFoundException("id - " + id);
            }
            return order;
        }

        @PutMapping("/{id}")
        Supplier updateSupplier(@RequestBody Supplier supplier, @PathVariable long id){
            Supplier updatedSupplier = service.updateById(supplier, id);
            if (updatedSupplier == null){
                throw new OrderNotFoundException("id - " + id);
            }
            return updatedSupplier;
        }

}
