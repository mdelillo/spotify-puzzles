package com.markdelillo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringEndsWith.endsWith;

public class MainTest {
    private final InputStream originalStdin = System.in;
    private final PrintStream originalStdout = System.out;
    private ByteArrayOutputStream capturedStdout;

    @Before
    public void captureStdout() {
        System.out.flush();
        capturedStdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturedStdout));
    }

    @After
    public void restoreStdinAndStdout() throws IOException {
        System.setIn(originalStdin);
        capturedStdout.close();
        System.setOut(originalStdout);
    }

    @Test
    public void testSampleCase1() {
        String input = "13";
        String expectedOutput = "11";
        sendToStdin(input);

        Main.main(new String[] {input});

        assertThat(capturedStdout.toString().trim(), endsWith(expectedOutput));
    }

    @Test
    public void testSampleCase2() {
        String input = "47";
        String expectedOutput = "61";
        sendToStdin(input);

        Main.main(new String[] {input});

        assertThat(capturedStdout.toString().trim(), endsWith(expectedOutput));
    }

    private void sendToStdin(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}