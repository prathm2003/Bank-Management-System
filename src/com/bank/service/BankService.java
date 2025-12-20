package com.bank.service;

public interface BankService {
    public void createAccount();
    public String Withdraw(double amount);
    public String Deposit(double amount);
    public void gettransaction(int page);
    public  String exist(String acc);
    public void accountdet();
}
