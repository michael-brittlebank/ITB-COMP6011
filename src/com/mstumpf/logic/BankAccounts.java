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

    public void getBankAccountInput(){

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

        System.out.println("Hello, World! You have "+this.numberOfAccounts+" "+accountString);

    }
}
