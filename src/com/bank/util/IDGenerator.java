package com.bank.util;

import com.bank.constant.Accounttype;

import java.util.UUID;

import static com.bank.constant.Accounttype.CURRENT;

public class IDGenerator {
    static int count1=0;
    static int count2=0;
    public String gentrrateAccountNumber(Accounttype accounttype){
        if(accounttype == Accounttype.SAVING){
            int c= ++count1;
            return "SAV" + c;
        }
        if(accounttype == Accounttype.CURRENT){
            int c= ++count2;
            return "SAV" + c;
        }
        return "account not created";
    }

    public String GenerateuserID(){
        return UUID.randomUUID().toString();
    }
}
