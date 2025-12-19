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

    public String Deposit(double amount){
        balance += amount;
        return amount+" is Deposited";
    }

    public String Withdraw(double amount){
        if(amount>balance){
            return "Insufficient balance";
        }
        balance -=amount;
        return amount+" is withdrawn" ;
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
