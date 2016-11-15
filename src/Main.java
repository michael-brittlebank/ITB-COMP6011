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

import com.mstumpf.logic.BankAccounts;

class Main {

    public static void main(String[] args){
        BankAccounts accounts = new BankAccounts();

        System.out.println("Welcome to Zero Bank.");

        accounts.getBankAccountsInput();

        accounts.getBankAccountsAction();
    }

}
