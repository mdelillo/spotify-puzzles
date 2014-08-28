package com.markdelillo;

public class ReverseBinary {
    private final int number;

    public ReverseBinary(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String toBinaryString() {
        int tempNumber = number;
        String binary = "";
        while (tempNumber > 0) {
            binary = (tempNumber % 2) + binary;
            tempNumber /= 2;
        }
        return binary;
    }
}