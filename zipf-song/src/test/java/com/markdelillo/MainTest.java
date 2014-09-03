package com.markdelillo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

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
    public void testSampleCase1() throws Exception {
        String input = getResourceFileAsString("sample_input_1");
        String expectedOutput = getResourceFileAsString("expected_output_1");
        sendToStdin(input);

        Main.main(new String[] {input});

        assertThat(capturedStdout.toString().trim(), equalTo(expectedOutput));
    }

    @Test
    public void testSampleCase2() throws Exception {
        String input = getResourceFileAsString("sample_input_2");
        String expectedOutput = getResourceFileAsString("expected_output_2");
        sendToStdin(input);

        Main.main(new String[] {input});

        assertThat(capturedStdout.toString().trim(), equalTo(expectedOutput));
    }

    private String getResourceFileAsString(String resourceFile) throws URISyntaxException, IOException {
        String input;
        URL url = Thread.currentThread().getContextClassLoader().getResource(resourceFile);
        Path path = null;
        if (url != null) {
            path = Paths.get(url.toURI());
        }
        input = new String(Files.readAllBytes(path));
        return input;
    }

    private void sendToStdin(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}