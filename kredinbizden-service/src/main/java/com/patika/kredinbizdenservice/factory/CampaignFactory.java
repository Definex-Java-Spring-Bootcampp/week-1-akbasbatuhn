package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.model.Campaign;

import java.time.LocalDate;

public class CampaignFactory implements AbstractFactory<Campaign> {

    private static volatile CampaignFactory instance;

    private CampaignFactory() {

    }

    public static synchronized CampaignFactory getInstance() {
        if (instance == null) {
            synchronized (CampaignFactory.class) {
                if (instance == null) {
                    instance = new CampaignFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public Campaign create(Object... args) {
        return new Campaign((String) args[0], (String) args[1],
                (LocalDate) args[2], (LocalDate) args[3], (LocalDate) args[4], (SectorType) args[5]);
    }
}
