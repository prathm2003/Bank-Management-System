package com.bank.model;

import com.bank.constant.Accounttype;
import com.bank.service.BankService;
import com.bank.util.IDGenerator;

public class Account{
    protected String accountNumber;
    protected User user;
    protected double balance;
    protected Accounttype accounttype;

    public Account( User user, double balance, Accounttype accounttype) {
        this.user = user;
        this.balance = balance;
        this.accounttype = accounttype;
        this.accountNumber = new IDGenerator().gentrrateAccountNumber(accounttype);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Accounttype getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(Accounttype accounttype) {
        this.accounttype = accounttype;
    }


    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", user=" + user +
                ", balance=" + balance +
                ", accounttype=" + accounttype +
                '}';
    }
}
