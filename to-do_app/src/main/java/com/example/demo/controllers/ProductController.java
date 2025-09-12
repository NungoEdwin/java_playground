package com.example.demo.controllers;

import java.util.List;
import com.example.demo.models.Product;
import com.example.demo.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService service;
    @GetMapping
    public List<Product> getAllProducts(){
        return service.getAllProd();
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return service.getProduct(id);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,Product updatedproduct) {
        return service.update(updatedproduct,id);
    }
    @PostMapping
    public void postMethodName(@RequestBody Product entity) {

        
     service.save(entity);;
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
      service.deleteProduct(id);
    }
    @DeleteMapping
    public void deleteAll(){
        service.deleteAll();
    }
    

    
}
