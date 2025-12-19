package com.bank.model;

import com.bank.constant.Accounttype;

public class SavingAccount extends Account {
    private static final double MIN_BALANCE = 10000;

    public SavingAccount( User user, double balance, Accounttype accounttype) {
        super( user, balance, accounttype);
    }
    public double getMinBalance(){
        return MIN_BALANCE;
    }
}
