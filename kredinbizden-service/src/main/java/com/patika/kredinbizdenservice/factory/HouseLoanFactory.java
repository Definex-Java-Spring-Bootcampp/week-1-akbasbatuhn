package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.model.HouseLoan;

import java.math.BigDecimal;

public class HouseLoanFactory implements AbstractFactory<HouseLoan> {

    private static volatile HouseLoanFactory instance;

    private HouseLoanFactory() {

    }

    public static synchronized HouseLoanFactory getInstance() {
        if (instance == null) {
            synchronized (HouseLoanFactory.class) {
                if (instance == null) {
                    instance = new HouseLoanFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public HouseLoan create(Object... args) {
        return new HouseLoan((BigDecimal) args[0], (Integer) args[1], (Double) args[2]);
    }
}
