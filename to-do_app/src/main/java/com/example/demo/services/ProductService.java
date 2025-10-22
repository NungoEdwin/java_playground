package com.example.demo.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repository;
    
    public List<Product> getAllProd(){
           return repository.findAll();
    }
    public Product getProduct(Long id){
       return repository.findById(id).orElse(null);
    }
    public void save(Product product){
        repository.save(product);
    }
    public Product update(Product updatedProduct,Long id){

        Product product = repository.findById(id).orElse(null);
        if (product!=null){
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            return repository.save(product);
        }
        return null;
    }
    public void deleteProduct(Long id){
        repository.deleteById(id);
    }
    public void deleteAll(){
        repository.deleteAll();
    }
    
}
