package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        NextHighestNumber nextHighestNumber = new NextHighestNumber();

        System.out.println("Please enter a number:");
        //String value = System.console().readLine();

        Scanner in = new Scanner(System.in);

        int value = in.nextInt();

        System.out.println("Next Highest Number is: " + nextHighestNumber.getNextHighestNumber(value));

    }
}
