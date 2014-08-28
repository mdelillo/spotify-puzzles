package com.markdelillo;

public class ReverseBinary {
    private final int number;

    public ReverseBinary(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static String decimalToBinaryString(int number) {
        String binary = "";
        while (number / 2 > 0) {
            binary = (number % 2) + binary;
            number /= 2;
        }
        binary = number + binary;
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
}