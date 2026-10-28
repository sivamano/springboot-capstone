package org.capstone.sb_capstone.dtos.product;

import lombok.Getter;
import lombok.Setter;
import org.capstone.sb_capstone.models.Category;
import org.capstone.sb_capstone.models.Product;

@Getter
@Setter
public class CreateProductRequestDto {
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private String categoryName;

    public Product toProduct(){
        Product product = new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
        Category category = new Category();
        category.setName(this.categoryName);
        product.setCategory(category);

        return  product;
    }

}
