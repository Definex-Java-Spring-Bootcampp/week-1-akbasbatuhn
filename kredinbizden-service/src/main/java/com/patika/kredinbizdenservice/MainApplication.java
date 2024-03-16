package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.factory.SingletonFactoryManager;
import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.ConsumerLoan;
import com.patika.kredinbizdenservice.model.CreditCard;
import com.patika.kredinbizdenservice.model.HouseLoan;
import com.patika.kredinbizdenservice.model.User;
import com.patika.kredinbizdenservice.model.VechileLoan;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
public class MainApplication {

    public static void main(String[] args) {
        SingletonFactoryManager factoryManager = SingletonFactoryManager.getInstance();

        User user = (User) factoryManager
                .createObject(User.class, "Batuhan", "Akbaş", "example@gmail.com", "password", "+905055055055");

        Bank akbank = (Bank) factoryManager
                .createObject(Bank.class, "Akbank");

        Bank isbank = (Bank) factoryManager
                .createObject(Bank.class, "İş Bankası");

        ConsumerLoan isbankConsumerLoan = (ConsumerLoan) factoryManager
                .createObject(ConsumerLoan.class, BigDecimal.valueOf(15000), 12, 1.09);
        VechileLoan isbankVehicleLoan = (VechileLoan) factoryManager
                .createObject(VechileLoan.class, BigDecimal.valueOf(500000), 36, 1.57);
        HouseLoan isbankHouseLoan = (HouseLoan) factoryManager
                .createObject(HouseLoan.class, BigDecimal.valueOf(3000000), 120, 1.90);

        isbankConsumerLoan.setBank(isbank);
        isbankHouseLoan.setBank(isbank);
        isbankVehicleLoan.setBank(isbank);

        isbank.setLoanList(List.of(isbankHouseLoan, isbankConsumerLoan, isbankVehicleLoan));

        CreditCard isbankCreditCard = (CreditCard) factoryManager
                .createObject(CreditCard.class, BigDecimal.valueOf(1.25), isbank);

        CreditCard isbankStudentCreditCard = (CreditCard) factoryManager
                .createObject(CreditCard.class, BigDecimal.valueOf(1.02), isbank);

        CreditCard akbankCreditCard = (CreditCard) factoryManager
                .createObject(CreditCard.class, BigDecimal.valueOf(1.38), akbank);

        isbank.setCreditCardsList(List.of(isbankCreditCard, isbankStudentCreditCard));
        akbank.setCreditCardsList(List.of(akbankCreditCard));


        log.info(isbank.toString());
        log.info(user.toString());
    }
}
