package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.Campaign;
import com.patika.kredinbizdenservice.model.ConsumerLoan;
import com.patika.kredinbizdenservice.model.CreditCard;
import com.patika.kredinbizdenservice.model.HouseLoan;
import com.patika.kredinbizdenservice.model.User;
import com.patika.kredinbizdenservice.model.VechileLoan;

public class SingletonFactoryManager {

    private static volatile SingletonFactoryManager instance;
    private FactoryManager factoryManager;

    private SingletonFactoryManager() {
        factoryManager = new FactoryManager();
        // Register factories
        factoryManager.registerFactory(Application.class, ApplicationFactory.getInstance());
        factoryManager.registerFactory(Bank.class, BankFactory.getInstance());
        factoryManager.registerFactory(Campaign.class, CampaignFactory.getInstance());
        factoryManager.registerFactory(ConsumerLoan.class, ConsumerLoanFactory.getInstance());
        factoryManager.registerFactory(CreditCard.class, CreditCardFactory.getInstance());
        factoryManager.registerFactory(HouseLoan.class, HouseLoanFactory.getInstance());
        factoryManager.registerFactory(User.class, UserFactory.getInstance());
        factoryManager.registerFactory(VechileLoan.class, VehicleLoanFactory.getInstance());
    }

    public static synchronized SingletonFactoryManager getInstance() {
        if (instance == null) {
            synchronized (SingletonFactoryManager.class) {
                if (instance == null) {
                    instance = new SingletonFactoryManager();
                }
            }
        }
        return instance;
    }

    public Object createObject(Class<?> key, Object... args) {
        return factoryManager.createObject(key, args);
    }
}
