package com.mstumpf.helpers;

import java.util.Scanner;

public class Validation {

    public static int getValidInteger(Scanner input, int minimumValue){
        return getValidInteger(input,minimumValue,Integer.MAX_VALUE);
    }

    public static int getValidInteger(Scanner input, int minimumValue, int maximumValue){
        int integerInput;
        do {
            integerInput = Input.getIntegerInput(input);
            if (integerInput < minimumValue){
                System.out.println("Please enter a number greater than "+minimumValue+".");
            } else if (integerInput > maximumValue){
                System.out.println("Please enter a number less than or equal to "+maximumValue+".");
            }
        } while(integerInput > maximumValue || integerInput < minimumValue);
        return integerInput;
    }

    public static double getValidDouble(Scanner input, double minimumValue) {
        return getValidDouble(input,minimumValue,Double.MAX_VALUE);
    }

    public static double getValidDouble(Scanner input, double minimumValue, double maximumValue){
        double doubleInput;
        do {
            doubleInput = Input.getDoubleInput(input);
            if (doubleInput < minimumValue){
                System.out.println("Please enter a number greater than "+String.format("%.2f", minimumValue)+".");
            } else if (doubleInput > maximumValue){
                System.out.println("Please enter a number less than or equal to "+String.format("%.2f", maximumValue)+".");
            }
        } while(doubleInput > maximumValue || doubleInput < minimumValue);
        return doubleInput;
    }
}
