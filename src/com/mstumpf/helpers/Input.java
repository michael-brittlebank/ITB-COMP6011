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
            return getIntegerInput(input);
        }
    }

}
