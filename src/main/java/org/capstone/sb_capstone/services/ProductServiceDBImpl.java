package org.capstone.sb_capstone.services;

import org.capstone.sb_capstone.models.Category;
import org.capstone.sb_capstone.models.Product;
import org.capstone.sb_capstone.repositories.CategoryRepository;
import org.capstone.sb_capstone.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductServiceDBImpl(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(Product product) {
        // fetch the value of category
        String categoryName = product.getCategory().getName();
        // see if that category is available in the db
        Optional<Category> category = categoryRepository.findByName(categoryName);
        Category toBePutInProduct = null;

        // if the category is not present in db, then save that as new category in db
        if(category.isEmpty()){
            Category toSaveCategory = new Category();
            toSaveCategory.setName(categoryName);
            toBePutInProduct = categoryRepository.save(toSaveCategory);
        }else{ // else use the value that is present in db
            toBePutInProduct = category.get();
        }
        product.setCategory(toBePutInProduct);
        Product savedProduct =  productRepository.save(product);
        return savedProduct;
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
