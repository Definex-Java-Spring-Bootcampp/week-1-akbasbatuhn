package com.patika.onlinealisveris.datamanager;

import com.patika.onlinealisveris.model.Order;
import com.patika.onlinealisveris.model.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductManager {

    private List<Product> products;
    private Set<String> productNames;

    public ProductManager() {
        productNames = new HashSet<>();
        products = new ArrayList<>();
    }

    public void addProduct(Product other) {
        if(productNames.contains(other.getName())) {
            for(Product product: products) {
                if(product.getName().equals(other.getName())) {
                    int amount = product.getStockAmount();
                    product.setStockAmount(amount + other.getStockAmount());
                }
            }
        }
    }

    public void addProducts(List<Product> list) {
        for(Product product : list)
            products.add(product);
    }

    public void buyProducts(Order order) {
        if(!determineCanOrderBeFulfilled(order))
            return;

        for(Product other : order.getProductList()) {
            for(Product product : products) {
                product.buyProduct(other.getStockAmount());
            }
        }
    }

    private boolean determineCanOrderBeFulfilled(Order order) {
        for(Product other : order.getProductList()) {
            for(Product product : products) {
                boolean hasFound = other.getName().equals(product.getName());
                boolean hasEnoughStockAmount = other.getStockAmount() > product.getStockAmount();
                if(hasFound && !hasEnoughStockAmount) return false;
            }
        }

        return true;
    }
}
