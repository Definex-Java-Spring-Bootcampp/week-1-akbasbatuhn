package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.model.Bank;

public class BankFactory implements AbstractFactory<Bank> {

    private static volatile BankFactory instance;

    private BankFactory() {

    }

    public static synchronized BankFactory getInstance() {
        if (instance == null) {
            synchronized (BankFactory.class) {
                if (instance == null) {
                    instance = new BankFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public Bank create(Object... args) {
        return new Bank((String) args[0]);
    }
}