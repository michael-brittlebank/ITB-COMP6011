package com.mstumpf.logic;

import java.util.Comparator;

class Account implements Comparable<Account>, Comparator<Account> {

    private String accountHolder;
    private double accountBalance;

    public Account(String accountHolder) {
        this(accountHolder,0);
    }

    public Account(String accountHolder, double accountBalance) {
        this.accountHolder = accountHolder;
        this.accountBalance = accountBalance;
    }

    public int compareTo(Account account)
    {
        return this.accountHolder.compareTo(account.getAccountHolder());
    }

    public int compare(Account account1, Account account2)
    {
        return account1.getAccountHolder().compareTo(account2.getAccountHolder());
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
        return "Account holder: "+this.getAccountHolder()+" & account balance: €"+String.format("%.2f", this.getAccountBalance());
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