package org.capstone.sb_capstone.services;

import org.capstone.sb_capstone.dtos.fakestore.FakeStoreProductRequestDto;
import org.capstone.sb_capstone.dtos.fakestore.FakeStoreProductResponseDto;
import org.capstone.sb_capstone.exceptions.ProductNotFoundException;
import org.capstone.sb_capstone.models.Category;
import org.capstone.sb_capstone.models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class ProductServiceFakeStoreImpl implements ProductService {
    private static final String BASE_URL = "https://fakestoreapi.com/products";
    private final RestTemplate restTemplate;

    public ProductServiceFakeStoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductResponseDto response = restTemplate.postForObject(
                BASE_URL, toRequestDto(product), FakeStoreProductResponseDto.class);
        return toProduct(response);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductResponseDto[] responses =
                restTemplate.getForObject(BASE_URL, FakeStoreProductResponseDto[].class);
        List<Product> products = new ArrayList<>();
        if (responses == null) return products;
        for (FakeStoreProductResponseDto dto : responses) {
            products.add(toProduct(dto));
        }
        return products;
    }

    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductResponseDto response = restTemplate.getForObject(
                BASE_URL + "/{id}", FakeStoreProductResponseDto.class, id);
        if (response == null) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
        return toProduct(response);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        ResponseEntity<FakeStoreProductResponseDto> responseEntity = restTemplate.exchange(
                BASE_URL + "/{id}", HttpMethod.PUT, new HttpEntity<>(toRequestDto(product)),
                FakeStoreProductResponseDto.class, id);
        return toProduct(responseEntity.getBody());
    }

    @Override
    public void deleteSingleProduct(Long id) {
        restTemplate.delete(BASE_URL + "/{id}", id);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existing = getSingleProduct(id);   // reuses the null check

        if (product.getTitle() != null)       existing.setTitle(product.getTitle());
        if (product.getDescription() != null) existing.setDescription(product.getDescription());
        if (product.getPrice() != null)       existing.setPrice(product.getPrice());
        if (product.getImageUrl() != null)    existing.setImageUrl(product.getImageUrl());
        if (product.getCategory() != null)    existing.setCategory(product.getCategory());

        restTemplate.put(BASE_URL + "/{id}", toRequestDto(existing), id);
        return existing;
    }

    // ---------- mapping helpers ----------

    private Product toProduct(FakeStoreProductResponseDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImageUrl(dto.getImage());

        Category category = new Category();
        category.setName(dto.getCategory());
        product.setCategory(category);
        return product;
    }

    private FakeStoreProductRequestDto toRequestDto(Product product) {
        FakeStoreProductRequestDto request = new FakeStoreProductRequestDto();
        request.setTitle(product.getTitle());
        request.setPrice(product.getPrice());
        request.setDescription(product.getDescription());
        request.setImage(product.getImageUrl());
        request.setCategory(product.getCategory() != null ? product.getCategory().getName() : null);
        return request;
    }
}