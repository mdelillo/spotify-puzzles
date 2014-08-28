package com.markdelillo;

import com.google.common.collect.ImmutableMap;
import junit.framework.TestCase;

import java.util.Map;

public class ReverseBinaryTest extends TestCase {

    public void testGetOriginalNumber() {
        int number = 6;
        ReverseBinary reverseBinary = new ReverseBinary(number);
        assertEquals(number, reverseBinary.getNumber());
    }

    public void testConvertDecimalToBinaryString() {
        Map<Integer, String> decimalToBinaryConversions = ImmutableMap.of(
                7, "111",
                10, "1010",
                20, "10100",
                32, "100000"
        );

        for (Map.Entry<Integer, String> entry : decimalToBinaryConversions.entrySet()) {
            assertEquals(entry.getValue(), convertToBinary(entry.getKey()));
        }
    }

    private String convertToBinary(int number) {
        return new ReverseBinary(number).toBinaryString();
    }
}
