package com.bank.service;

import com.bank.constant.Accounttype;
import com.bank.model.Account;
import com.bank.model.User;

import java.util.Scanner;

public class BankServiceImplementation implements BankService {
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
        double bal =0;
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
        System.out.println(account);
    }
}
