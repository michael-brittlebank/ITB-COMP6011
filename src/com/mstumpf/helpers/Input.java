package com.mstumpf.helpers;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Input {

    public static int getIntegerInput(Scanner input) {
        try {
            return input.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter an integer.");
            input.next();
            //recursion
            return getIntegerInput(input);
        }
    }

    public static double getDoubleInput(Scanner input) {
        try {
            return input.nextDouble();
        } catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter a double.");
            input.next();
            //recursion
            return getDoubleInput(input);
        }
    }

    public static String getStringInput(Scanner input) {
        try {
            return input.next();
        } catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter a string.");
            input.next();
            //recursion
            return getStringInput(input);
        }
    }

}
