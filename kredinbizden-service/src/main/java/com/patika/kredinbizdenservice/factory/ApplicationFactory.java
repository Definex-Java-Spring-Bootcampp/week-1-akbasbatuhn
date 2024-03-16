package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.Loan;
import com.patika.kredinbizdenservice.model.User;

import java.time.LocalDateTime;

public class ApplicationFactory implements AbstractFactory<Application> {

    private static volatile ApplicationFactory instance;

    private ApplicationFactory() {

    }

    public static synchronized ApplicationFactory getInstance() {
        if (instance == null) {
            synchronized (ApplicationFactory.class) {
                if (instance == null) {
                    instance = new ApplicationFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public Application create(Object... args) {
        return new Application((Loan) args[0], (User) args[1], (LocalDateTime) args[2]);
    }
}
