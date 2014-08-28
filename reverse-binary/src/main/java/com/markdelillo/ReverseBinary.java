package com.markdelillo;

import java.util.Scanner;

public class ReverseBinary {
    private final int number;

    public ReverseBinary(int number) {
        if (number < 1 || number > 1000000000) {
            throw new IllegalArgumentException(String.format("Illegal number %d. Number must be between 1 and 1000000000", number));
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int getReversedNumber() {
        StringBuilder binary = new StringBuilder(decimalToBinaryString(number));
        return binaryStringToDecimal(binary.reverse().toString());
    }

    public static String decimalToBinaryString(int number) {
        String binary = "";
        while (number > 0) {
            binary = (number % 2) + binary;
            number /= 2;
        }
        return binary;
    }

    public static int binaryStringToDecimal(String binary) {
        int position = 0;
        int decimal = 0;
        while (!binary.isEmpty()) {
            if (binary.endsWith("1")) {
                decimal += Math.pow(2, position);
            }
            position++;
            binary = binary.substring(0, binary.length() - 1);
        }
        return decimal;
    }


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