package com.markdelillo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter number to be reversed (between 1 and 1000000000): ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        try {
            ReverseBinary reverseBinary = new ReverseBinary(number);
            System.out.println(reverseBinary.getReversedNumber());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
