package com.mstumpf.helpers;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Input {

    public static int getIntegerInput(Scanner input) {
        try {
            return input.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter an integer.");
            //recursion
            return getIntegerInput(input);
        }
    }

    public static double getDoubleInput(Scanner input) {
        try {
            return input.nextDouble();
        } catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter a double.");
            //recursion
            return getDoubleInput(input);
        }
    }

    public static String getStringInput(Scanner input) {
        try {
            String inputLine = input.next().trim();
            if (inputLine.length() > 0) {//check that it's not just whitespace
                return inputLine;
            } else {
                System.out.println("Invalid input. Please enter a string of at least one character.");
                return getStringInput(input);//recursion
            }
        } catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter a string.");
            //recursion
            return getStringInput(input);
        }
    }

}
