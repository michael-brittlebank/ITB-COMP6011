/* *************************************************/
/* Assignment 1 */
/* Written by: Mike Stumpf */
/* Course: COMP H6011 */
/* Language: Java */
/* Date Started: November 15, 2016 */
/* Last Update: December 12, 2016 */
/* Program Description: A banking institution */
/* requires a simple program for processing and analysing */
/* Account holders’ details. For simplicity and ease of */
/* testing reasons, the bank has a relatively small number */
/* of Account holders (maximum of 20).  */
/* *************************************************/

import java.util.ArrayList;
import java.util.Scanner;
import com.mstumpf.Account;

public class Main {

    public static void main(String[] args) {

        ArrayList<Account> bankAccounts = new ArrayList<>();

        bankAccounts.add(new Account("John", 1.14));

        for(Account bankAccount:bankAccounts){//enhanced for loop
            System.out.println(bankAccount.toString());
        }

        System.out.println("Hello, World!");
    }

}
