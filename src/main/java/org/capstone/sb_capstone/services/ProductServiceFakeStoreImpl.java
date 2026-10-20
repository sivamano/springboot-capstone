package org.capstone.sb_capstone.services;

import org.capstone.sb_capstone.dtos.FakeStoreProductRequestDto;
import org.capstone.sb_capstone.dtos.FakeStoreProductResponseDto;
import org.capstone.sb_capstone.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class ProductServiceFakeStoreImpl implements ProductService {
    private final RestTemplate restTemplate;

    public ProductServiceFakeStoreImpl(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    @Override
    public Product createProduct(Product product) {
        FakeStoreProductRequestDto request = new FakeStoreProductRequestDto();
        request.setTitle(product.getTitle());
        request.setPrice(product.getPrice());
        request.setDescription(product.getDescription());
        request.setImage(product.getImageUrl());
        request.setCategory(product.getCategoryName());
        FakeStoreProductResponseDto response = restTemplate.postForObject("https://fakestoreapi.com/products",
                request,
                FakeStoreProductResponseDto.class);

        Product product1 = new Product();
        product1.setId(response.getId());
        product1.setTitle(request.getTitle());
        product1.setDescription(request.getDescription());
        product1.setPrice(request.getPrice());
        product1.setCategoryName(response.getCategory());
        product1.setImageUrl(response.getImage());
        return product1;
    }
}
