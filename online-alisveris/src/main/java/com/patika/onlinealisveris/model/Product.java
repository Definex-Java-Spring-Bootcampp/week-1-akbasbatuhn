package com.patika.onlinealisveris.model;

import com.patika.onlinealisveris.enums.CategoryType;

import java.math.BigDecimal;

public class Product {

    private CategoryType category;
    private BigDecimal price;
    private String name;
    private int stockAmount;

    public Product(String name, BigDecimal price, int stockAmount, CategoryType category) {
        this.price = price;
        this.name = name;
        this.stockAmount = stockAmount;
        this.category = category;
    }

    public void buyProduct(int amount) {
        stockAmount -= amount;
    }

    public boolean hasEnoughStockAmount(int amount) {
        return stockAmount >= amount;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "category=" + category +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", stockAmount=" + stockAmount +
                '}';
    }
}
