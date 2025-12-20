package com.bank.app;

import com.bank.constant.Accounttype;
import com.bank.model.Account;
import com.bank.model.User;
import com.bank.repository.BankRepository;
import com.bank.service.BankService;
import com.bank.service.BankServiceImplementation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class bankapplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService bank = new BankServiceImplementation();
        while(true){
            try {
                System.out.println("1:create Account");
                System.out.println("2:Existing Account");
                System.out.println("3: exit");
                System.out.print("enter the Choice: ");
                int ch = sc.nextInt();
                sc.nextLine();
                switch (ch) {
                    case 1:
                        bank.createAccount();
                        break;
                    case 2:
                        System.out.print("enter account number: ");
                        String acc = sc.nextLine();
                        System.out.println(bank.exist(acc));
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Exit");
                        continue;
                }
                int temp = 0;
                while (temp != 1) {
                    try {
                        System.out.println("1:Deposit");
                        System.out.println("2:Withdraw");
                        System.out.println("3:Show Transactions");
                        System.out.println("4:Account Details");
                        System.out.println("5:Logout");
                        System.out.print("Enter the choice: ");
                        int ch2 = sc.nextInt();
                        switch (ch2) {
                            case 1:
                                System.out.print("Enter the amount you wants to deposit: ");
                                double amount = sc.nextDouble();
                                bank.Deposit(amount);
                                break;
                            case 2:
                                System.out.print("Enter the amount you wants to Withdraw: ");
                                double amt = sc.nextDouble();
                                bank.Withdraw(amt);
                                break;
                            case 3:
                                System.out.print("give transaction page: ");
                                int p = sc.nextInt();
                                sc.nextLine();
                                bank.gettransaction(p);
                                break;
                            case 4:
                                bank.accountdet();
                                break;
                            case 5:
                                temp = 1;
                            default:
                                System.out.println("Invalid input");

                        }
                    }catch (InputMismatchException e){
                        System.out.println("invalid input");
                        sc.nextLine();
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("invalid input");
                sc.nextLine();
            }
        }
    }
}
