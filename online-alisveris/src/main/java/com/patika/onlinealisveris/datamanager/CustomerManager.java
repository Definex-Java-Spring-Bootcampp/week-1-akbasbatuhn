package com.patika.onlinealisveris.datamanager;

import com.patika.onlinealisveris.model.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {

    private List<Customer> customerList;

    public CustomerManager() {
        customerList = new ArrayList<>();
    }

    public void addCustomerToDatabase(Customer customer) {
        customerList.add(customer);
    }

    public int getCustomerAmount() {
        return customerList.size();
    }


    public List<Customer> findCustomersByName(String name) {
        List<Customer> customers = new ArrayList<>();

        for(Customer customer: customerList) {
            if(customer.getName().equals(name)) {
                customers.add(customer);
            }
        }

        return customers;
    }

    public List<Customer> findCustomersByAgeBetween25And30(String name) {
        List<Customer> customers = new ArrayList<>();

        for(Customer customer: customerList) {
            int age = LocalDate.now().getYear() - customer.getBirthDate().getYear();
            if(age > 25 && age < 30 && customer.getName().equals(name)) {
                customers.add(customer);
            }
        }

        return customers;
    }
}
