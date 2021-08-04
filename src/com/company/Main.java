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

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        do {

            System.out.println("Please enter a number (or 'X' to exit):");
            //String value = System.console().readLine();

            value = in.nextLine();

            if (!nextHighestNumber.isStringInInteger(value)  ) {
                if (!value.equals("x") && !value.equals("X")) {
                    System.out.println("String is out of bound or not in integer format.");
                }

            }
            else{
                System.out.println("Next Highest Number is: " + nextHighestNumber.getNextHighestNumber(value));
            }

        }while( !value.equals("x") && !value.equals("X") );

    }
}
