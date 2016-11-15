package com.mstumpf;

public class Account {

    private String accountHolder;
    private double accountBalance;

    public Account(String accountHolder, double accountBalance) {
        this.accountHolder = accountHolder;
        this.accountBalance = accountBalance;
    }

    public void setAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
    }

    public String getAccountHolder(){
        return this.accountHolder;
    }

    public void setAccountBalance(double accountBalance){
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance(){
        return this.accountBalance;
    }

    public String toString() {
        return "This Account is owned by "+this.accountHolder;
    }

}
