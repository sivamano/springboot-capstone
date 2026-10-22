package org.capstone.sb_capstone.dtos;

import lombok.Getter;
import lombok.Setter;
import org.capstone.sb_capstone.models.Product;

@Getter
@Setter
public class CreateProductResponseDto {
    private Long id;
    private String Title;
    private String description;
    private Double price;
    private String imageUrl;
    private String categoryName;

    public static CreateProductResponseDto fromProduct(Product product){
    CreateProductResponseDto responseDto = new CreateProductResponseDto();
    responseDto.setId(product.getId());
    responseDto.setTitle(product.getTitle());
    responseDto.setDescription(product.getDescription());
    responseDto.setPrice(product.getPrice());
    responseDto.setImageUrl(product.getImageUrl());
    responseDto.setCategoryName(product.getCategoryName());

    return  responseDto;
    }
}
