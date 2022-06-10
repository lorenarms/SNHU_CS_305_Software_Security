package com.twk.restservice;

public class customer {
	private int account_number;
    int account_balance;

    public int showInfo() {
        //code to show customer information 
    	return this.account_number;
    }

    public void deposit(int a) {
            account_balance = account_balance + a;
    }
}
