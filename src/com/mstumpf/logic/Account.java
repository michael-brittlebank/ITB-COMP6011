package com.mstumpf.logic;

import java.util.Comparator;

class Account {

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

class AccountBalanceComparator implements Comparator<Account> {
    public int compare(Account account1, Account account2) {
        double account1Balance = account1.getAccountBalance();
        double account2Balance = account2.getAccountBalance();
        if (account1Balance < account2Balance) {
            return 1;
        } else if (account1Balance > account2Balance){
            return -1;
        } else {
            return 0;
        }
    }
}

class AccountHolderComparator implements Comparator<Account> {
    public int compare(Account account1, Account account2) {
        return account1.getAccountHolder().compareTo(account2.getAccountHolder());
    }
}