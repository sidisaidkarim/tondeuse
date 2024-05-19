package org.example.controller;

import org.example.io.FileInputParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LawnMowerRunnerTest {

    private static final String TEST_FILE_PATH = "src/test/resources/test_input.txt";
    private static FileInputParser fileInputParser;
    private static LawnMowerRunner lawnMowerRunner;

    @BeforeEach
    void setUp() {
        fileInputParser = new FileInputParser();
        lawnMowerRunner = new LawnMowerRunner(fileInputParser,TEST_FILE_PATH);
    }

    @Test
    void runMowersTest() throws IOException {
        String result = lawnMowerRunner.RunMowers();
        assertEquals("1 3 N 5 1 E",result);
    }
}