package org.capstone.sb_capstone.services;

import org.springframework.stereotype.Service;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService{
    @Override
    public void createProduct(String title, String description, double price, String imageUrl, String categoryName) {

    }
}
