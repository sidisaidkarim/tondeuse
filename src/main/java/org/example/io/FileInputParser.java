package org.example.io;

import org.example.enums.Direction;
import org.example.lawn.Lawn;
import org.example.lawn.RectangularLawn;
import org.example.mower.Mower;
import org.example.mower.StandardMower;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileInputParser implements InputParser{
    public Lawn parseLawn(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String[] lawnLimits = reader.readLine().split(" ");
            int maxX = Integer.parseInt(lawnLimits[0]);
            int maxY = Integer.parseInt(lawnLimits[1]);
            return new RectangularLawn(maxX, maxY);
        }
    }

    public List<Mower> parseMowers(String filePath) throws IOException {


        List<Mower> mowers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String regex = "([1-9]+ [1-9]+ [N,E,S,W])";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String[] mowerInit = matcher.group().split(" ");
                    int x = Integer.parseInt(mowerInit[0]);
                    int y = Integer.parseInt(mowerInit[1]);
                    Direction direction = Direction.valueOf(mowerInit[2]);
                    Mower mower = new StandardMower(x, y, direction);
                    mowers.add(mower);

                }

            }
        }
        return mowers;
    }

    public List<String> parseInstructions(String filePath) throws IOException {
        List<String> instructions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String regex = "([AGD]+)";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    instructions.add(matcher.group());
                }
            }
        }

        return instructions;
    }
}
