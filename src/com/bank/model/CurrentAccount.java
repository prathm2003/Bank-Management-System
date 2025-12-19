package com.bank.model;

import com.bank.constant.Accounttype;

public class CurrentAccount extends Account{
    private static final double MAX_BALANCE = 1000000;

    public CurrentAccount(User user, double balance, Accounttype accounttype) {
        super(user, balance, accounttype);
    }
    public double getMaxBalance(){
        return MAX_BALANCE;
    }
}
