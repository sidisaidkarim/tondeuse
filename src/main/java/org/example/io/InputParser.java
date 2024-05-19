package org.example.io;

import org.example.lawn.Lawn;
import org.example.mower.Mower;

import java.io.IOException;
import java.util.List;

public interface InputParser {
    Lawn parseLawn(String source) throws IOException;
    List<Mower> parseMowers(String source) throws IOException;
    List<String> parseInstructions(String source) throws IOException;

}
