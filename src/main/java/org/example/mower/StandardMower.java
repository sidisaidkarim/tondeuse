package org.example.mower;

import org.example.enums.Direction;
import org.example.lawn.Lawn;

public class StandardMower implements Mower{
    private Position position;
    private Direction direction;

    public StandardMower(int x, int y, Direction direction) {
        this.position = new Position(x, y);
        this.direction = direction;
    }

    @Override
    public void executeInstructions(String instructions, Lawn lawn) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'G':
                    turnLeft();
                    break;
                case 'D':
                    turnRight();
                    break;
                case 'A':
                    moveForward(lawn);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid instruction: " + instruction);
            }
        }
    }

    private void turnLeft() {
        direction = direction.turnLeft();
    }

    private void turnRight() {
        direction = direction.turnRight();
    }

    private void moveForward(Lawn lawn) {
        int newX = position.getX();
        int newY = position.getY();
        switch (direction) {
            case N:
                newY++;
                break;
            case E:
                newX++;
                break;
            case S:
                newY--;
                break;
            case W:
                newX--;
                break;
        }
        if (lawn.isInside(newX, newY)) {
            position.setX(newX);
            position.setY(newY);
        }
    }

    @Override
    public String getPosition() {
        return position.getX() + " " + position.getY() + " " + direction;
    }
}
