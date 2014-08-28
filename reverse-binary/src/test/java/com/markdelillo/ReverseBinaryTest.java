package com.markdelillo;

import com.google.common.collect.ImmutableMap;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class ReverseBinaryTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    public static final Map<Integer, String> DECIMAL_TO_BINARY_CONVERSIONS = ImmutableMap.<Integer, String>builder()
            .put(1, "1")
            .put(10, "1010")
            .put(32, "100000")
            .put(42, "101010")
            .put(63, "111111")
            .put(1000000000, "111011100110101100101000000000")
            .build();

    @Test
    public void testNumberMustBeGreaterThanOrEqualToOne() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Number must be between 1 and 1000000000");
        new ReverseBinary(0);
    }

    @Test
    public void testNumberMustBeLessOrEqualToThan1000000000() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Number must be between 1 and 1000000000");
        new ReverseBinary(1000000001);
    }

    @Test
    public void testGetOriginalNumber() {
        int number = 6;
        ReverseBinary reverseBinary = new ReverseBinary(number);
        assertEquals(number, reverseBinary.getNumber());
    }

    @Test
    public void testConvertDecimalToBinaryString() {
        for (Map.Entry<Integer, String> entry : DECIMAL_TO_BINARY_CONVERSIONS.entrySet()) {
            assertEquals(getBinaryFromEntry(entry), ReverseBinary.decimalToBinaryString(getDecimalFromEntry(entry)));
        }
    }

    @Test
    public void testConvertBinaryStringToDecimal() {
        for (Map.Entry<Integer, String> entry : DECIMAL_TO_BINARY_CONVERSIONS.entrySet()) {
            assertEquals(getDecimalFromEntry(entry), ReverseBinary.binaryStringToDecimal(getBinaryFromEntry(entry)));
        }
    }

    @Test
    public void testGetReversedNumber() {
        Map<Integer, Integer> reversedNumbers = ImmutableMap.<Integer, Integer>builder()
                .put(1, 1)
                .put(10, 5)
                .put(21, 21)
                .put(32, 1)
                .put(42, 21)
                .put(63, 63)
                .put(1000000000, 1365623)
                .build();
        for (Map.Entry<Integer, Integer> entry : reversedNumbers.entrySet()) {
            assertEquals(getReversedNumberFromEntry(entry), reverseNumber(getNumberFromEntry(entry)));
        }
    }


    private String getBinaryFromEntry(Map.Entry<Integer, String> entry) {
        return entry.getValue();
    }

    private int getDecimalFromEntry(Map.Entry<Integer, String> entry) {
        return entry.getKey();
    }

    private int getReversedNumberFromEntry(Map.Entry<Integer, Integer> entry) {
        return entry.getValue();
    }

    private int getNumberFromEntry(Map.Entry<Integer, Integer> entry) {
        return entry.getKey();
    }

    private int reverseNumber(int number) {
        return new ReverseBinary(number).getReversedNumber();
    }
}
