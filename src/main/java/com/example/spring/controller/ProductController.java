package com.example.spring.controller;

import com.example.spring.model.Product;
import com.example.spring.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAll() throws Exception {
        return service.getProducts();
    }
    @GetMapping("/filter")
    public List<Product> filterProducts(
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Double minPopularity
    ) throws Exception {
        List<Product> allProducts = service.getProducts();

        return allProducts.stream()
                .filter(p -> minPrice == null || p.getPrice() >= minPrice)
                .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
                .filter(p -> minPopularity == null || p.getPopularity() >= minPopularity)
                .toList();
    }

}
