package com.bank.service;

import com.bank.constant.Accounttype;
import com.bank.model.Account;
import com.bank.model.User;
import com.bank.repository.BankRepository;

import java.time.LocalDateTime;
import java.util.Scanner;

public class BankServiceImplementation implements BankService {
    static double bal =0;
    String record = null;
    public void createAccount() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter mobile no.: ");
        int mob = sc.nextInt();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        User u1 = new User(name,mob,address,email);
        System.out.print("Enter Initial balance to add in the account");
        while(bal<=10000){
            System.out.print("(balance be greater than or equal to 10000): ");
            bal= sc.nextDouble();
        }
        System.out.println("Enter Account type:");
        System.out.println("1:Saving");
        System.out.println("2:Current");
        int acc = sc.nextInt();
        Accounttype accounttype = Accounttype.SAVING;
        if(acc==1){
            accounttype = Accounttype.SAVING;
        }
        if(acc==2){
            accounttype = Accounttype.CURRENT;
        }
        Account account = new Account(u1,bal, accounttype);
        BankRepository.account.put(account.getAccountNumber(),account);
        record = LocalDateTime.now() + "|" + bal + "| cr";
        BankRepository.transactions.add(record);
    }
    public String Deposit(double amount){
        bal += amount;
        record = LocalDateTime.now() + "|" + bal + "| cr";
        BankRepository.transactions.add(record);
        return amount+" is Deposited";
    }

    public String Withdraw(double amount){
        if(amount>bal){
            record = LocalDateTime.now() + "|" + bal + "| failed";
            BankRepository.transactions.add(record);
            return "Insufficient balance";
        }
        bal -=amount;
        record = LocalDateTime.now() + "|" + bal + "| dr";
        BankRepository.transactions.add(record);
        return amount+" is withdrawn" ;
    }

}
