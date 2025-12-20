package com.bank.repository;

import com.bank.model.Account;

import java.util.ArrayList;
import java.util.HashMap;

public class BankRepository {
    public static HashMap<String, Account> account = new HashMap<>();

    public static HashMap<String ,ArrayList<String>> transactions= new HashMap<>();

}
