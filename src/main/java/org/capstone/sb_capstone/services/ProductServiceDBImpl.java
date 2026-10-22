package org.capstone.sb_capstone.services;

import org.capstone.sb_capstone.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService{

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getSingleProduct(Long id) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteSingleProduct(Long id) {
    }

    /**
     * @param id
     * @param product
     * @return
     */
    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }
}
