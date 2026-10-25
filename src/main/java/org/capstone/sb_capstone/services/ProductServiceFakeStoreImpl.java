package org.capstone.sb_capstone.services;

import org.capstone.sb_capstone.dtos.fakestore.FakeStoreProductRequestDto;
import org.capstone.sb_capstone.dtos.fakestore.FakeStoreProductResponseDto;
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
        product1.setTitle(response.getTitle());
        product1.setDescription(response.getDescription());
        product1.setPrice(response.getPrice());
        product1.setCategoryName(response.getCategory());
        product1.setImageUrl(response.getImage());
        return product1;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductResponseDto[] responses = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductResponseDto[].class);
        List<Product> products = new ArrayList<Product>();
        for(FakeStoreProductResponseDto dto : responses) {
            Product product = new Product();
            product.setId(dto.getId());
            product.setTitle(dto.getTitle());
            product.setDescription(dto.getDescription());
            product.setPrice(dto.getPrice());
            product.setCategoryName(dto.getCategory());
            product.setImageUrl(dto.getImage());

            products.add(product);
        }
        return products;
    }

    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductResponseDto response = restTemplate.getForObject("https://fakestoreapi.com/products/{id}",
                FakeStoreProductResponseDto.class,id);

        Product product1 = new Product();
        product1.setId(response.getId());
        product1.setTitle(response.getTitle());
        product1.setDescription(response.getDescription());
        product1.setPrice(response.getPrice());
        product1.setCategoryName(response.getCategory());
        product1.setImageUrl(response.getImage());
        return product1;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        FakeStoreProductRequestDto request = new FakeStoreProductRequestDto();
        request.setTitle(product.getTitle());
        request.setPrice(product.getPrice());
        request.setDescription(product.getDescription());
        request.setImage(product.getImageUrl());
        request.setCategory(product.getCategoryName());
        ResponseEntity<FakeStoreProductResponseDto> responseEntity = restTemplate.exchange("https://fakestoreapi.com/products/{id}", HttpMethod.PUT,new HttpEntity<>(request),
                FakeStoreProductResponseDto.class,id);

        FakeStoreProductResponseDto response = responseEntity.getBody();

        Product product1 = new Product();
        product1.setId(response.getId());
        product1.setTitle(response.getTitle());
        product1.setDescription(response.getDescription());
        product1.setPrice(response.getPrice());
        product1.setCategoryName(response.getCategory());
        product1.setImageUrl(response.getImage());
        return product1;
    }

    /**
     * @param id This is a path variable
     */
    @Override
    public void deleteSingleProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/{id}",id);
    }

    /**
     * @param id
     * @param product
     * @return
     */
    @Override
    public Product updateProduct(Long id, Product product) {
        FakeStoreProductRequestDto existing =  restTemplate.getForObject("https://fakestoreapi.com/products/{id}",
                FakeStoreProductRequestDto.class,
                id);
        FakeStoreProductRequestDto request = new FakeStoreProductRequestDto();
        request.setTitle(product.getTitle() != null ? product.getTitle() : existing.getTitle());
        request.setPrice(product.getPrice() != null ? product.getPrice(): existing.getPrice());
        request.setDescription(product.getDescription() !=null ? product.getDescription() : existing.getDescription());
        request.setImage(product.getImageUrl() != null ? product.getImageUrl() : existing.getImage());
        request.setCategory(product.getCategoryName() != null ? product.getCategoryName() : existing.getCategory());


        restTemplate.put("https://fakestoreapi.com/products/{id}",
                request,
                id);

        Product product1 = new Product();
        product1.setId(id);
        product1.setTitle(request.getTitle());
        product1.setDescription(request.getDescription());
        product1.setPrice(request.getPrice());
        product1.setCategoryName(request.getCategory());
        product1.setImageUrl(request.getImage());

        return product1;
    }


}
