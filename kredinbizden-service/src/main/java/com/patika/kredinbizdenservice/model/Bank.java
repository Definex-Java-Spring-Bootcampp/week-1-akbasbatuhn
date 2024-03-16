package com.patika.kredinbizdenservice.model;

import java.util.List;

public class Bank {

    public Bank(String name) {
        this.name = name;
    }

    private String name;
    private List<Loan> loanList;
    private List<CreditCard> creditCards;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    public List<CreditCard> getCreditCardsList() {
        return creditCards;
    }

    public void setCreditCardsList(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    @Override
    public String toString() {
        return "Bank {" +
                "\nname='" + name + '\'' +
                ", \nloanList=" + loanList +
                ", \ncreditCardList=" + creditCards +
                "\n}";
    }
}
