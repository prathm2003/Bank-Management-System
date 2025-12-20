package com.bank.service;

import com.bank.constant.Accounttype;
import com.bank.model.Account;
import com.bank.model.User;
import com.bank.repository.BankRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class BankServiceImplementation implements BankService {
    static double bal =0;
    String record = null;
    static String accno = null;
    public String exist(String acc){
        if(BankRepository.account.containsKey(acc)) {
            accno = acc;
            return "Logged in Successsfully";
        }
        return "Account not exists";
    }
    public void createAccount() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter mobile no.: ");
        int mob = sc.nextInt();
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
        accno = account.getAccountNumber();
        ArrayList<String> temp = new ArrayList<>();
        BankRepository.account.put(account.getAccountNumber(),account);
        record = LocalDateTime.now() + "|" + bal + "| cr";
        temp.add(record);
        BankRepository.transactions.put(account.getAccountNumber(),temp);
    }
    public String Deposit(double amount){
        double b=BankRepository.account.get(accno).getBalance();
        b += amount;
        BankRepository.account.get(accno).setBalance(b);
        record = LocalDateTime.now() + "| Amount" + amount + "| cr"+" | balance"+b;
        BankRepository.transactions.get(accno).add(record);
        return amount+" is Deposited";
    }

    public String Withdraw(double amount){
        double b=BankRepository.account.get(accno).getBalance();
        if(amount>b){
            record = LocalDateTime.now() + "| amount" + amount+ " failed"+"| balance"+b;
            BankRepository.transactions.get(accno).add(record);
            return "Insufficient balance";
        }
        b -=amount;
        record = LocalDateTime.now() + "|" + amount + "| dr"+"| balance"+b;
        BankRepository.transactions.get(accno).add(record);
        BankRepository.account.get(accno).setBalance(b);
        return amount+" is withdrawn" ;
    }
    public void gettransaction(int page){
        ArrayList<String> list = BankRepository.transactions.get(accno);
        int limit =2;
        int t = page*limit;
        System.out.println(list.get(t-1));
        System.out.println(list.get(t));

    }
    public void accountdet(){
        System.out.println(BankRepository.account.get(accno));
    }
}
