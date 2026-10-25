package org.capstone.sb_capstone.dtos.product;

import lombok.Getter;
import lombok.Setter;
import org.capstone.sb_capstone.models.Product;

@Getter
@Setter
public class GetProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private String categoryName;

    public static GetProductResponseDto fromProduct(Product product){
        GetProductResponseDto responseDto = new GetProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setTitle(product.getTitle());
        responseDto.setDescription(product.getDescription());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageUrl(product.getImageUrl());
        responseDto.setCategoryName(product.getCategoryName());

        return  responseDto;
    }
}
