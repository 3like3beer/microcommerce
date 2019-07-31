package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductDao productDao;

    @GetMapping("/produits")
    public List<Product> showAllProducts(){
        return productDao.findAll();
    }

    @GetMapping("/produits/{id}")
    public Product showProduct(@PathVariable int id){
        return productDao.findById(id);
    }

    @PostMapping("/produits")
    public ResponseEntity<Void> createProduit(@RequestBody Product product) {
        Product productAdded = productDao.save(product);

        if (productAdded == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }
}
