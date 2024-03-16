package com.patika.onlinealisveris.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Product> productList;
    private Customer customer;
    private String shipmentAddress;

    public Order(Customer customer, String shipmentAddress) {
        this.productList = new ArrayList<>();
        this.customer = customer;
        this.shipmentAddress = shipmentAddress;
    }

    public BigDecimal calculateOrderTotalAmount() {
         BigDecimal total = BigDecimal.valueOf(0);
         for(Product product: productList) {
             total = total.add(product.getPrice().multiply(BigDecimal.valueOf(product.getStockAmount())));
         }

         return total;
    }

    public void addProductToOrder(Product product) {
        productList.add(product);

    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getShipmentAddress() {
        return shipmentAddress;
    }

    public void setShipmentAddress(String shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "productList=" + productList +
                ", customerName=" + customer.getName() +
                ", address='" + shipmentAddress + '\'' +
                '}';
    }
}
