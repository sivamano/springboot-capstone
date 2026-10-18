package org.capstone.sb_capstone.controllers;

import org.capstone.sb_capstone.dtos.CreateProductRequestDto;
import org.capstone.sb_capstone.dtos.CreateProductResponseDto;
import org.capstone.sb_capstone.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prodcuts")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
        }
    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        return null;
    }


    @GetMapping("")
    public void getAllProducts(){

    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable("id") Long id){
        return "Here is your product, with ID as " +id;
    }

    @PutMapping("")
    public void updateProduct(){

    }

    @DeleteMapping("/{id}")
    public void deleteProduct(){

    }

    @RequestMapping(name="SIVA", value="")
    public String magicRequest(){
        return "Magic";
    }

}
