package org.capstone.sb_capstone.controllers;

import org.capstone.sb_capstone.dtos.CreateProductRequestDto;
import org.capstone.sb_capstone.dtos.CreateProductResponseDto;
import org.capstone.sb_capstone.dtos.GetProductResponseDto;
import org.capstone.sb_capstone.models.Product;
import org.capstone.sb_capstone.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {
        Product product = productService.createProduct(createProductRequestDto.toProduct());
        return CreateProductResponseDto.fromProduct(product);
    }


    @GetMapping("")
    public List<GetProductResponseDto> getAllProducts() {
        List<Product> products =  productService.getAllProducts();

        List<GetProductResponseDto> responseDtos = new ArrayList<>();
        for(Product product: products){
            responseDtos.add(GetProductResponseDto.fromProduct(product));
        }
        return responseDtos;
    }

    @GetMapping("/{id}")
    public GetProductResponseDto getProduct(@PathVariable("id") Long id) {
        Product product = productService.getSingleProduct(id);
        return GetProductResponseDto.fromProduct(product);
    }

    @PatchMapping("/{id}")
    public void updateProduct() {

    }

    @DeleteMapping("/{id}")
    public void deleteProduct() {

    }

    @PutMapping("/{id}")
    public CreateProductResponseDto replaceProduct(  @PathVariable("id") Long id,
                               @RequestBody CreateProductRequestDto createProductRequestDto) {
        Product product = productService.replaceProduct(id,createProductRequestDto.toProduct());
        return CreateProductResponseDto.fromProduct(product);

    }

}
