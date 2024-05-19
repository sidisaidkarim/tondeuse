package org.example.io;

import org.example.enums.Direction;
import org.example.lawn.Lawn;
import org.example.lawn.RectangularLawn;
import org.example.mower.Mower;
import org.example.mower.StandardMower;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileInputParserTest {

    private static final String TEST_FILE_PATH = "src/test/resources/test_input_in_one_line.txt";
    private static FileInputParser fileInputParser;


    @BeforeAll
    static void setUp() throws IOException {
        fileInputParser = new FileInputParser();

    }

    @Test
    void parseLawnTest() throws IOException{
        Lawn lawn = fileInputParser.parseLawn(TEST_FILE_PATH);
        assertTrue(lawn instanceof RectangularLawn);
        RectangularLawn rectangularLawn = (RectangularLawn) lawn;
        assertEquals(5, rectangularLawn.getMaxX());
        assertEquals(5, rectangularLawn.getMaxY());
    }

    @Test
    void parseMowersTest() throws IOException{
        List<Mower> mowers = fileInputParser.parseMowers(TEST_FILE_PATH);
        assertEquals(2, mowers.size());
        assertEquals(new StandardMower(1,2, Direction.N).getPosition(),mowers.get(0).getPosition());
    }

    @Test
    void parseInstructionsTest() throws IOException{
        List<String> instructions = fileInputParser.parseInstructions(TEST_FILE_PATH);
        assertEquals(2, instructions.size());
        assertEquals("GAGAGAGAA",instructions.get(0));
    }
}