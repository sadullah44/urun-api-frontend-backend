package com.example.spring.model;

import java.util.Map;

public class Product {
    private String name;
    private double popularityScore;
    private double weight;
    private Map<String, String> images;

    private double price;
    private double popularity;

    public String getName() {
        return name;
    }

    public double getPopularityScore() {
        return popularityScore;
    }

    public Map<String, String> getImages() {
        return images;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopularityScore(double popularityScore) {
        this.popularityScore = popularityScore;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setImages(Map<String, String> images) {
        this.images = images;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }
}
