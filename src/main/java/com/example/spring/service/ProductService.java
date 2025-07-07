package com.example.spring.service;

import com.example.spring.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.util.List;

@Service
public class ProductService {
    public List<Product> getProducts() throws Exception {
        InputStream is = new ClassPathResource("products.json").getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        List<Product> products = mapper.readValue(is, new TypeReference<List<Product>>() {});

        double goldPrice = fetchGoldPrice();

        for (Product product : products) {
            double price = (product.getPopularityScore() + 1) * product.getWeight() * goldPrice;
            product.setPrice(Math.round(price * 100.0) / 100.0);
            product.setPopularity(Math.round(product.getPopularityScore() * 5 * 10.0) / 10.0);
        }

        return products;
    }

    private double fetchGoldPrice() {
        try {
            String url = "https://api.coingecko.com/api/v3/simple/price?ids=gold&vs_currencies=usd";
            RestTemplate restTemplate = new RestTemplate();
            String json = restTemplate.getForObject(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readTree(json).path("gold").path("usd").asDouble(75.0);
        } catch (Exception e) {
            return 75.0; // fallback
        }
    }
}
