package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.model.VechileLoan;

import java.math.BigDecimal;

public class VehicleLoanFactory implements AbstractFactory<VechileLoan> {

    private static volatile VehicleLoanFactory instance;

    private VehicleLoanFactory() {

    }

    public static synchronized VehicleLoanFactory getInstance() {
        if (instance == null) {
            synchronized (VehicleLoanFactory.class) {
                if (instance == null) {
                    instance = new VehicleLoanFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public VechileLoan create(Object... args) {
        return new VechileLoan((BigDecimal) args[0], (Integer) args[1], (Double) args[2]);
    }
}
