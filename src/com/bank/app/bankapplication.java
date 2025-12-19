package com.bank.app;

import com.bank.constant.Accounttype;
import com.bank.model.Account;
import com.bank.model.User;
import com.bank.repository.BankRepository;
import com.bank.service.BankService;
import com.bank.service.BankServiceImplementation;

import java.util.Scanner;

public class bankapplication {
    public static void main(String[] args) {
        BankService bank = new BankServiceImplementation();
        bank.createAccount();
        bank.Deposit(5000);
        System.out.println(BankRepository.transactions);
    }
}
