package com.mstumpf.logic;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import com.mstumpf.helpers.Input;
import com.mstumpf.helpers.Validation;

public class BankAccounts {

    private int numberOfAccounts;
    private ArrayList<Account> bankAccounts;
    private ArrayList<Account> sortedBankAccountsByBalance;
    private ArrayList<Account> sortedBankAccountsByName;
    private Scanner input;
    private double averageAccountBalance;
    private double highestAccountBalance;
    private double lowestAccountBalance;

    //overloaded constructor
    public BankAccounts() {
        this(0);
    }

    public BankAccounts(int numberOfAccounts) {
        this.bankAccounts = new ArrayList<>();
        this.numberOfAccounts = numberOfAccounts;
        this.input = new Scanner(System.in);
        this.input.useDelimiter("\\n");
    }

    public void getBankAccountsInput(){

        String accountString = "account";

        if(this.numberOfAccounts == 0){
            System.out.println("Please enter the number of bank accounts.");
            this.numberOfAccounts = Validation.getValidInteger(input, 1, 20);
        }

        do {
            System.out.printf("Please enter the holder's name for account #%d.\n",this.bankAccounts.size()+1);
            String accountHolder = Input.getStringInput(input);
            System.out.printf("Please enter the balance for account #%d.\n",this.bankAccounts.size()+1);
            double accountBalance = Validation.getValidDouble(input, 0);
            this.bankAccounts.add(new Account(accountHolder, accountBalance));
        } while(this.bankAccounts.size() < this.numberOfAccounts);

        //plural
        if (this.bankAccounts.size() != 1){
            accountString += "s";
        }

        System.out.printf("Hello, you have %d %s.\n",this.bankAccounts.size(),accountString);

    }

    public void getBankAccountsAction(){
        int actionId;
        do {
            System.out.println("\n-----What action would you like to perform?-----");
            System.out.println("Option 1: Display average account balance");
            System.out.println("Option 2: Display highest account balance");
            System.out.println("Option 3: Display lowest account balance");
            System.out.println("Option 4: Display the account balances in descending order");
            System.out.println("Option 5: Search for an individual account holder by name");
            System.out.println("Option 6: Exit and quit program");
            actionId = Input.getIntegerInput(input);
            switch(actionId){
                case 1:
                    displayAverageAccountBalance();
                    break;
                case 2:
                    displayHighestAccountBalance();
                    break;
                case 3:
                    displayLowestAccountBalance();
                    break;
                case 4:
                    displaySortedAccountBalances();
                    break;
                case 5:
                    displayAccountSearchResults();
                    break;
                case 6:
                    System.out.println("Thank you, goodbye.");
                    break;
                default:
                    System.out.println("Invalid option selected.");
            }
        } while(actionId != 6);
    }

    /**
     * display methods
     */

    private void displayAverageAccountBalance(){
        double accountBalance;
        if (this.averageAccountBalance != 0){
            accountBalance = this.averageAccountBalance;
        } else {
            accountBalance = this.averageAccountBalance = getAverageAccountBalance();
        }
        System.out.printf("Average account balance: €%s\n",String.format("%.2f", accountBalance));
    }

    private void displayHighestAccountBalance(){
        double accountBalance;
        if (this.highestAccountBalance != 0){
            accountBalance = this.highestAccountBalance;
        } else {
            accountBalance = this.highestAccountBalance = getHighestAccountBalance();
        }
        System.out.printf("Highest account balance: €%s\n",String.format("%.2f", accountBalance));
    }

    private void displayLowestAccountBalance(){
        double accountBalance;
        if (this.lowestAccountBalance != 0){
            accountBalance = this.lowestAccountBalance;
        } else {
            accountBalance = this.lowestAccountBalance = getLowestAccountBalance();
        }
        System.out.printf("Lowest account balance: €%s\n",String.format("%.2f", accountBalance));
    }

    private void displaySortedAccountBalances() {
        sortBankAccountsByBalance();
        for(Account account:this.sortedBankAccountsByBalance){
            System.out.printf("Balance: €%s\n",String.format("%.2f", account.getAccountBalance()));
        }
    }

    private void displayAccountSearchResults(){
        System.out.println("Whose account do you want to search for?");
        String accountHolder = Input.getStringInput(input);
        System.out.println(getAccountByHolder(accountHolder));
    }

    /**
     * getter methods
     */

    private double getAverageAccountBalance(){
        double totalBalances = 0;
        for(Account account:this.bankAccounts){
            totalBalances += account.getAccountBalance();
        }
        return totalBalances/this.bankAccounts.size();
    }

    private double getHighestAccountBalance(){
        sortBankAccountsByBalance();
        return this.sortedBankAccountsByBalance.get(0).getAccountBalance();
    }

    private double getLowestAccountBalance(){
        sortBankAccountsByBalance();
        return this.sortedBankAccountsByBalance.get(this.sortedBankAccountsByBalance.size()-1).getAccountBalance();
    }

    private String getAccountByHolder(String accountHolder){
        sortBankAccountsByHolder();
        int searchIndex = Collections.binarySearch(this.sortedBankAccountsByName, new Account(accountHolder));
        if (searchIndex >= 0) {
            return this.sortedBankAccountsByName.get(searchIndex).toString();
        } else {
            return "Account holder not found";
        }
    }

    /**
     * sorter methods
     */
    private void sortBankAccountsByBalance(){
        if (this.sortedBankAccountsByBalance == null || this.sortedBankAccountsByBalance.isEmpty()) {
            this.sortedBankAccountsByBalance = this.bankAccounts;
            Collections.sort(this.sortedBankAccountsByBalance, new AccountBalanceComparator());
        }
    }

    private void sortBankAccountsByHolder(){
        if (this.sortedBankAccountsByName == null || this.sortedBankAccountsByName.isEmpty()) {
            this.sortedBankAccountsByName = this.bankAccounts;
            Collections.sort(this.sortedBankAccountsByName, new AccountHolderComparator());
        }
    }
}
