package com.patika.kredinbizdenservice.database;

import com.patika.kredinbizdenservice.dto.UserAndLoanDTO;
import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.Loan;
import com.patika.kredinbizdenservice.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationDatabase {

    private List<Application> applicationList;
    private Map<String, Integer> map;

    public ApplicationDatabase() {
        applicationList = new ArrayList<>();
        map = new HashMap<>();
    }

    public void addApplication(Application application) {
        String email = application.getUser().getEmail();

        if(!map.containsKey(email)) {
            map.put(email, 1);
        } else {
            map.put(email, map.get(email) + 1);
        }

        applicationList.add(application);
    }

    public User findMostApplicationCountUser() {
        User user = null;
        int most = 0;
        for(Application application: applicationList) {
            if(application.getUser().getApplicationList().size() > most) {
                most = application.getUser().getApplicationList().size();
                user = application.getUser();
            }
        }

        return user;
    }

    public List<Application> findLastMonthsApplications() {
        List<Application> appList = new ArrayList<>();

        LocalDateTime oneMonthEarlier = LocalDateTime.now().minusDays(30);
        for(Application application: applicationList) {
            if(application.getLocalDateTime().isAfter(oneMonthEarlier))
                appList.add(application);
        }

        return appList;
    }

    public List<Application> findAllApplicationsByMail(String email) {
        List<Application> result = new ArrayList<>();

        for(Application application : applicationList) {
            if(application.getUser().getEmail().equals(email))
                result.add(application);
        }

        return result;
    }

    public String findUserWithHighestLoanRequested() {
        if(applicationList.isEmpty()) return "No application found";

        User result = null;
        Loan loan = null;

        BigDecimal highestLoan = BigDecimal.valueOf(0);

        for(Application application: applicationList) {
            if(application.getLoan().getAmount().compareTo(highestLoan) > 0) {
                result = application.getUser();
                loan = application.getLoan();
            }
        }

        return new UserAndLoanDTO(result, loan).toString();
    }
}
