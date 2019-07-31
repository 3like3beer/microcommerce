package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductDaoImpl implements  ProductDao {
    private List<Product> products = new ArrayList<>();// Arrays.asList(new Product(1,"phone",10));

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        return products.stream().filter(p-> (p.getId() == id)).findFirst().get();
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }
}
