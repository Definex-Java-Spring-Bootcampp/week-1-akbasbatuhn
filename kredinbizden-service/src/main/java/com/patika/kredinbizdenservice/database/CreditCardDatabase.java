package com.patika.kredinbizdenservice.database;

import com.patika.kredinbizdenservice.model.Campaign;
import com.patika.kredinbizdenservice.model.CreditCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CreditCardDatabase {

    private List<CreditCard> creditCardList;

    public CreditCardDatabase() {
        creditCardList = new ArrayList<>();
    }

    public void addCreditCard(CreditCard creditCard) {
        creditCardList.add(creditCard);
    }

    public List<CreditCard> getCreditCards() {
        return creditCardList;
    }

    public List<CreditCard> sortCreditCardsByCampaignCount() {
        Collections.sort(creditCardList, Comparator.comparingInt(card -> {
            if (card instanceof CreditCard) {
                List<Campaign> campaignList = ((CreditCard) card).getCampaignList();
                return campaignList == null ? 0 : campaignList.size();
            }
            return 0;
        }).reversed());
        return creditCardList;
    }
}
