package com.mstumpf.logic;

import java.util.Scanner;
import java.util.ArrayList;
import com.mstumpf.helpers.Input;

public class BankAccounts {

    private int numberOfAccounts;
    private ArrayList<Account> bankAccounts;
    private Scanner input;

    //overloaded constructor
    public BankAccounts() {
        this(0);
    }

    public BankAccounts(int numberOfAccounts) {
        this.bankAccounts = new ArrayList<>();
        this.numberOfAccounts = numberOfAccounts;
        this.input = new Scanner(System.in);
    }

    public void getBankAccountsInput(){

        String accountString = "account";

        if(this.numberOfAccounts == 0){
            int temporaryInput;
            System.out.println("Please enter the number of bank accounts.");
            do {
                temporaryInput = Input.getIntegerInput(input);
                if (temporaryInput < 1){
                    System.out.println("Please enter a number greater than 0.");
                } else if (temporaryInput > 20){
                    System.out.println("Please enter a number less than or equal to 20.");
                }
            } while(temporaryInput > 20 || temporaryInput < 1);
            this.numberOfAccounts = temporaryInput;
        }

        bankAccounts.add(new Account("John", 1.14));

        for(Account bankAccount:bankAccounts){//enhanced for loop
            System.out.println(bankAccount.toString());
        }

        //plural
        if (this.numberOfAccounts != 1){
            accountString += "s";
        }

        System.out.println("Hello, you have "+this.numberOfAccounts+" "+accountString);

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
                    System.out.println("Display average account balance.");
                    break;
                case 2:
                    System.out.println("Display the highest account balance.");
                    break;
                case 3:
                    System.out.println("Display lowest account balance.");
                    break;
                case 4:
                    System.out.println("Sort & Display the account balances in descending order.");
                    break;
                case 5:
                    System.out.println("Search for an individual account holder by name.");
                    break;
                case 6:
                    System.out.println("Thank you, goodbye.");
                    break;
                default:
                    System.out.println("Invalid option selected.");
            }
        } while(actionId != 6);
    }
}
