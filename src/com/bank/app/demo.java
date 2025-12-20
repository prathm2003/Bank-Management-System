package com.bank.app;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class demo {
    public static void main(String[] args) {
        ArrayList<Integer> aa = new ArrayList<>();
        aa.add(1);
        ArrayList<Integer> ab = new ArrayList<>();
        ab.add(2);
        ArrayList<Integer> ac = new ArrayList<>();
        ac.add(3);
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        re.add(aa);
        re.add(ab);
        re.add(ac);
        int check = 2;
        int temp =0;
        int i=0,j=0;
        for (ArrayList<Integer> l1:re){
            for(int a:l1){
                if(a==check){
                    temp = a;
                    System.out.println("the no found");
                    System.out.println("i,j:"+i+","+j);
                    return;
                }
                j++;
            }
            i++;
        }
        System.out.println("no not found");
    }
}
