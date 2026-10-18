package org.capstone.sb_capstone.services;

public interface ProductService {

    void createProduct(String title,
                       String description,
                       double price,
                       String imageUrl,
                       String categoryName);

}
