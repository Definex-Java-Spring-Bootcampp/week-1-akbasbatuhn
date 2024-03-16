package com.patika.kredinbizdenservice.dto;

import com.patika.kredinbizdenservice.model.Loan;
import com.patika.kredinbizdenservice.model.User;

public class UserAndLoanDTO {

    private User user;
    private Loan loan;

    public UserAndLoanDTO(User user, Loan loan) {
        this.user = user;
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "User {" +
                "\nname='" + user.getName() + '\'' +
                ", \nloan=" + loan.toString() +
                "\n}";
    }
}
