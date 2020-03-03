package com.aman.inventory_management.controller;

import com.aman.inventory_management.exception.ProductNotFoundException;
import com.aman.inventory_management.model.Product;
import com.aman.inventory_management.repository.ProductDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    private ProductDaoService service;

    @GetMapping
    List<Product> retrieveAllProducts(){
        return service.findAll();
    }

    @PostMapping
    Product retrieveProduct(@RequestBody Product product){
        return service.save(product);
    }

    @DeleteMapping("/{id}")
    Product deleteProduct(@PathVariable long id){
        Product product = service.deleteById(id);
        if (product == null){
            throw new ProductNotFoundException("id - " + id);
        }
        return product;
    }

    @PutMapping("/{id}")
    Product updateProduct(@RequestBody Product product, @PathVariable java.lang.Long id){
        Product updatedProduct = service.updateById(product, id);
        if (product == null){
            throw new ProductNotFoundException("id - " + id);
        }
        return updatedProduct;
    }
}
