package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        NextHighestNumber nextHighestNumber = new NextHighestNumber();

        Scanner in = new Scanner(System.in);
        String value = "";

        do {

            System.out.println("Please enter a number (or 'X' to exit):");
            //String value = System.console().readLine();

            value = in.nextLine();

            if (!nextHighestNumber.isStringInInteger(value)  ) {
                if (!value.equals("x") && !value.equals("X")) {
                    System.out.println("String is not in integer format.");
                }

            }
            if(!nextHighestNumber.isStringInInteger(value)){
                System.out.println("String is not in integer format.");
            }
            else{
                System.out.println("Next Highest Number is: " + nextHighestNumber.getNextHighestNumber(value));
            }

        }while( !value.equals("x") && !value.equals("X") );

    }
}
