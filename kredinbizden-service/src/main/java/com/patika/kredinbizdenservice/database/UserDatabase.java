package com.patika.kredinbizdenservice.database;

import com.patika.kredinbizdenservice.dto.UserAndLoanDTO;
import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.Loan;
import com.patika.kredinbizdenservice.model.User;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class UserDatabase {

    private List<User> userList;
    private Set<String> emailSet ;

    public UserDatabase() {
        userList = new ArrayList<>();
        emailSet = new HashSet<>();
    }

    public List<User> getUsers() {
        return userList;
    }

    public boolean isEmailRegistered(String email) {
        return emailSet.contains(email);
    }

    public void addUser(User user) {
        if(isEmailRegistered(user.getEmail()))
            log.warn("{} is already exist. You can create 1 user with same email!!", user.getEmail());

        userList.add(user);
        emailSet.add(user.getEmail());
    }

    public User findByUserEmail(String email) {
        if(userList.isEmpty())
            return null;

        for(User user: userList) {
            if(user.getEmail().equals(email))
                return user;
        }

        return null;
    }
}
