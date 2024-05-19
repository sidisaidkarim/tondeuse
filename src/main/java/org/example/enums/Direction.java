package org.example.enums;

public enum Direction {
    N("North"),
    E("East"),
    S("South"),
    W("West");

    private String orientation;

    Direction(String orientation) {
        this.orientation = orientation;
    }

    public String getOrientation(){
        return this.orientation;
    }

    public Direction turnRight() {
        switch (this) {
            case N:
                return E;
            case E:
                return S;
            case S:
                return W;
            case W:
                return N;
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    public Direction turnLeft() {
        switch (this) {
            case N:
                return W;
            case E:
                return N;
            case S:
                return E;
            case W:
                return S;
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }
}
