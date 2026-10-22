package org.capstone.sb_capstone.services;

import org.capstone.sb_capstone.models.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product getSingleProduct(Long id);
    Product replaceProduct(Long id, Product product);
}
