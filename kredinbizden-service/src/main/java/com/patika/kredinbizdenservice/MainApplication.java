package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.database.ApplicationDatabase;
import com.patika.kredinbizdenservice.database.CreditCardDatabase;
import com.patika.kredinbizdenservice.database.UserDatabase;
import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.factory.SingletonFactoryManager;
import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.Campaign;
import com.patika.kredinbizdenservice.model.ConsumerLoan;
import com.patika.kredinbizdenservice.model.CreditCard;
import com.patika.kredinbizdenservice.model.HouseLoan;
import com.patika.kredinbizdenservice.model.User;
import com.patika.kredinbizdenservice.model.VechileLoan;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
public class MainApplication {

    private static final String LINE_BREAK = "------------------------------------------------------------";

    public static void main(String[] args) {
        SingletonFactoryManager factoryManager = SingletonFactoryManager.getInstance();

        User userBatuhan = (User) factoryManager
                .createObject(User.class, "Batuhan", "Akbaş", "example@gmail.com", "password", "+905000000000");

        User userBatuhan2 = (User) factoryManager
                .createObject(User.class, "Batuhan2", "Akbaş2", "example@gmail.com", "password2", "+905555555555");

        User userCem = (User) factoryManager
                .createObject(User.class, "Cem", "Dırman", "cemdrman@gmail.com", "password1", "+905055055055");

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

        Campaign isbankCampaign = (Campaign) factoryManager
                .createObject(Campaign.class,
                        "Isbank first campaign", "Content", LocalDate.now(),
                        LocalDate.now(), LocalDate.now(), SectorType.MARKET);
        Campaign isbankCampaign2 = (Campaign) factoryManager
                .createObject(Campaign.class,
                        "Isbank second campaign", "Content", LocalDate.now(),
                        LocalDate.now(), LocalDate.now(), SectorType.MARKET);

        Campaign isbankCampaign3 = (Campaign) factoryManager
                .createObject(Campaign.class,
                        "Isbank third campaign", "Content", LocalDate.now(),
                        LocalDate.now(), LocalDate.now(), SectorType.MARKET);

        Campaign isbankCampaign4 = (Campaign) factoryManager
                .createObject(Campaign.class,
                        "Isbank another campaign", "Content", LocalDate.now(),
                        LocalDate.now(), LocalDate.now(), SectorType.TRAVELS);

        Campaign akbankCampaign = (Campaign) factoryManager
                .createObject(Campaign.class,
                        "Akbank first campaign", "Content", LocalDate.now(),
                        LocalDate.now(), LocalDate.now(), SectorType.TRAVELS);

        Campaign akbankCampaign2 = (Campaign) factoryManager
                .createObject(Campaign.class,
                        "Akbank second campaign", "Content", LocalDate.now(),
                        LocalDate.now(), LocalDate.now(), SectorType.TRAVELS);

        isbankCreditCard.setCampaignList(List.of(isbankCampaign4));
        isbankStudentCreditCard.setCampaignList(List.of(isbankCampaign, isbankCampaign2, isbankCampaign3));
        akbankCreditCard.setCampaignList(List.of(akbankCampaign, akbankCampaign2));

        Application application = (Application) factoryManager
                .createObject(Application.class, isbankConsumerLoan, userCem, LocalDateTime.now());

        ApplicationDatabase applicationDatabase = new ApplicationDatabase();
        CreditCardDatabase creditCardDatabase = new CreditCardDatabase();
        UserDatabase userDatabase = new UserDatabase();

        creditCardDatabase.addCreditCard(isbankCreditCard);
        creditCardDatabase.addCreditCard(isbankStudentCreditCard);
        creditCardDatabase.addCreditCard(akbankCreditCard);

        applicationDatabase.addApplication(application);

        log.info(isbank.toString());
        log.info(userBatuhan.toString());

        log.info(LINE_BREAK);

        // Sort credit cards by campaign amount
        // Before
        log.info(creditCardDatabase.getCreditCards().toString());
        creditCardDatabase.sortCreditCardsByCampaignCount();
        // After
        log.info(creditCardDatabase.getCreditCards().toString());

        log.info(LINE_BREAK);

        // User password hashed with using SHA-512 algorithm
        log.info(userBatuhan.getPassword());

        log.info(LINE_BREAK);

        // userBatuhan2 not saved to database
        userDatabase.addUser(userBatuhan);
        userDatabase.addUser(userBatuhan2);
        userDatabase.addUser(userCem);

        log.info(userDatabase.getUsers().toString());

        log.info(LINE_BREAK);

        log.info(applicationDatabase.findUserWithHighestLoanRequested());

        log.info(LINE_BREAK);

        log.info(applicationDatabase.findAllApplicationsByMail(userCem.getEmail()).toString());
    }
}
