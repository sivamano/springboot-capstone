package org.capstone.sb_capstone.controllers;

import org.capstone.sb_capstone.dtos.CreateProductRequestDto;
import org.capstone.sb_capstone.dtos.CreateProductResponseDto;
import org.capstone.sb_capstone.models.Product;
import org.capstone.sb_capstone.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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
    public void getAllProducts() {

    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable("id") Long id) {
        return "Here is your product, with ID as " + id;
    }

    @PutMapping("")
    public void updateProduct() {

    }

    @DeleteMapping("/{id}")
    public void deleteProduct() {

    }

    @RequestMapping(name = "SIVA", value = "")
    public String magicRequest() {
        return "Magic";
    }

}
