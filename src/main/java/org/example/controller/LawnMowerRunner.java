package org.example.controller;

import org.example.io.FileInputParser;
import org.example.lawn.Lawn;
import org.example.mower.Mower;

import java.io.IOException;
import java.util.List;

public class LawnMowerRunner {
    private Lawn lawn;
    private List<Mower> mowers;
    private FileInputParser inputParser;
    private String filePath;



    public LawnMowerRunner(FileInputParser fileInputParser, String filePath) {
        this.filePath = filePath;
        this.inputParser = fileInputParser;
    }

    public String RunMowers() throws IOException {
        this.lawn = this.inputParser.parseLawn(this.filePath);
        this.mowers = this.inputParser.parseMowers(this.filePath);
        List<String> instructions = this.inputParser.parseInstructions(this.filePath);

        String finalPositionOfMowers = "";

        for(int i= 0; i < this.mowers.size(); i++){
            Mower mowerToRun = mowers.get(i);
            mowerToRun.executeInstructions(instructions.get(i),this.lawn);
            finalPositionOfMowers += mowerToRun.getPosition();
            if(i < this.mowers.size()-1) finalPositionOfMowers += " ";
        }

        return finalPositionOfMowers;
    }
}
