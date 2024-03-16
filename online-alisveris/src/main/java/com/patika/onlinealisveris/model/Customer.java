package com.patika.onlinealisveris.model;

import java.time.LocalDate;
import java.util.List;

public class Customer {

    private List<Order> orderList;
    private String address;
    private String name;
    private String surname;
    private LocalDate birthDate;

    public Customer(String name, String surname, LocalDate birthDate, String address) {
        this.address = address;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "orderList=" + orderList +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate.toString() +
                '}';
    }
}
