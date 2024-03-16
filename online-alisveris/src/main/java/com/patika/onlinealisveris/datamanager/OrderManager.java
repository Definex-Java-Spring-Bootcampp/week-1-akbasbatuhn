package com.patika.onlinealisveris.datamanager;

import com.patika.onlinealisveris.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    private List<Order> orders;

    public OrderManager() {
        orders = new ArrayList<>();
    }

    public void addOrderToDatabase(Order order) {
        orders.add(order);
    }

    public void addOrdersToDatabase(List<Order> list) {
        for(Order order : list) {
            orders.add(order);
        }
    }
}
