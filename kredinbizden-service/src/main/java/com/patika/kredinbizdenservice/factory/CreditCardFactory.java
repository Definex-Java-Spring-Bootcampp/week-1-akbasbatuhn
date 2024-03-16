package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.CreditCard;

import java.math.BigDecimal;

public class CreditCardFactory implements AbstractFactory<CreditCard> {

    private static volatile CreditCardFactory instance;

    CreditCardFactory() {

    }

    public static synchronized CreditCardFactory getInstance() {
        if (instance == null) {
            synchronized (CreditCardFactory.class) {
                if (instance == null) {
                    instance = new CreditCardFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public CreditCard create(Object... args) {
        return new CreditCard((BigDecimal) args[0], (Bank) args[1]);
    }
}
