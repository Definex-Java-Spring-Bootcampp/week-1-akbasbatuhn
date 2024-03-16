package com.patika.onlinealisveris.datamanager;

import com.patika.onlinealisveris.model.Bill;
import com.patika.onlinealisveris.model.Customer;
import com.patika.onlinealisveris.model.Order;
import com.patika.onlinealisveris.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BillManager {
    private CustomerManager customerManager;

    private List<Bill> bills;

    public BillManager(CustomerManager customerManager) {
        bills = new ArrayList<>();
        this.customerManager = customerManager;
    }

    public void addBillToDatabase(Bill bill) {
        bills.add(bill);
    }

    public List<Bill> findBillsThatTotalOverGivenAmount(BigDecimal min) {
        List<Bill> result = new ArrayList<>();

        for(Bill bill : bills) {
            if(bill.getTotalAmount().compareTo(min) > 0)
                result.add(bill);
        }

        return result;
    }

    public BigDecimal calculateTotalBillAmountOfGivenCustomerNameBetweenAgeOf25And30(String name) {
        List<Customer> customers = customerManager.findCustomersByAgeBetween25And30(name);
        BigDecimal totalAmount = BigDecimal.ZERO;

        for(Customer customer : customers) {
            if(customer.getOrderList() == null) {
                totalAmount.add(BigDecimal.ZERO);
                continue;
            }

            for(Order order: customer.getOrderList()) {
                totalAmount = totalAmount.add(order.calculateOrderTotalAmount());
            }
        }

        return totalAmount;
    }

    public int calculateTotalProductSoldToGivenCustomerName(String name) {
        int totalProductAmount = 0;
        List<Customer> customers = customerManager.findCustomersByName(name);

        for(Customer customer : customers) {
            for(Order order: customer.getOrderList()) {
                for(Product product : order.getProductList()) {
                    totalProductAmount += product.getStockAmount();
                }
            }
        }

        return totalProductAmount;
    }
}
