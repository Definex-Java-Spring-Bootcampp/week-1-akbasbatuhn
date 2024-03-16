package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.model.ConsumerLoan;

import java.math.BigDecimal;

public class ConsumerLoanFactory implements AbstractFactory<ConsumerLoan> {
    private static volatile ConsumerLoanFactory instance;

    private ConsumerLoanFactory() {

    }

    public static synchronized ConsumerLoanFactory getInstance() {
        if (instance == null) {
            synchronized (ConsumerLoanFactory.class) {
                if (instance == null) {
                    instance = new ConsumerLoanFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public ConsumerLoan create(Object... args) {
        return new ConsumerLoan((BigDecimal) args[0], (Integer) args[1], (Double) args[2]);
    }
}
