package com.mstumpf.logic;

import java.util.Scanner;
import java.util.ArrayList;
import com.mstumpf.helpers.Input;
import com.mstumpf.helpers.Validation;

public class BankAccounts {

    private int numberOfAccounts;
    private ArrayList<Account> bankAccounts;
    private Scanner input;
    private double averageAccountBalance;
    private double highestAccountBalance;
    private double lowestAccountBalance;
    private boolean bankAccountsSorted;

    //overloaded constructor
    public BankAccounts() {
        this(0);
    }

    public BankAccounts(int numberOfAccounts) {
        this.bankAccounts = new ArrayList<>();
        this.numberOfAccounts = numberOfAccounts;
        this.input = new Scanner(System.in);
        this.input.useDelimiter("\\n"); //http://stackoverflow.com/questions/5032356/using-scanner-nextline
        this.bankAccountsSorted = false;
    }

    public void getBankAccountsInput(){

        String accountString = "account";

        if(this.numberOfAccounts == 0){
            System.out.println("Please enter the number of bank accounts.");
            this.numberOfAccounts = Validation.getValidInteger(input, 1, 20);
        }

        do {
            System.out.printf("Please enter the name for account #%d.\n",this.bankAccounts.size()+1);
            String accountName = Input.getStringInput(input);
            System.out.printf("Please enter the balance for account #%d.\n",this.bankAccounts.size()+1);
            double accountBalance = Validation.getValidDouble(input, 0);
            this.bankAccounts.add(new Account(accountName, accountBalance));
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
            System.out.println("Option 4: Sort & Display the account balances in descending order");
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
        System.out.printf("Average account balance: %f\n",accountBalance);
    }

    private void displayHighestAccountBalance(){
        double accountBalance;
        if (this.highestAccountBalance != 0){
            accountBalance = this.highestAccountBalance;
        } else {
            accountBalance = this.highestAccountBalance = getHighestAccountBalance();
        }
        System.out.printf("Highest account balance: %f\n",accountBalance);
    }

    private void displayLowestAccountBalance(){
        double accountBalance;
        if (this.highestAccountBalance != 0){
            accountBalance = this.lowestAccountBalance;
        } else {
            accountBalance = this.lowestAccountBalance = getLowestAccountBalance();
        }
        System.out.printf("Lowest account balance: %f\n",accountBalance);
    }

    private void displaySortedAccountBalances() {
        System.out.println("Sort & Display the account balances in descending order.");
        if (!bankAccountsSorted){
            bankAccountsSorted = true;
            //sort array
        }
        //for loop print
    }

    private void displayAccountSearchResults(){
        System.out.println("Search for an individual account holder by name.");
        System.out.println(getAccountByHolder("john"));
    }

    /**
     * getter methods
     */

    private double getAverageAccountBalance(){
        return 0;
    }

    private double getHighestAccountBalance(){
        return 0;
    }

    private double getLowestAccountBalance(){
        return 0;
    }

    private Account getAccountByHolder(String accountHolder){
        //error handling, return string
        return new Account("john",11);
    }

}
