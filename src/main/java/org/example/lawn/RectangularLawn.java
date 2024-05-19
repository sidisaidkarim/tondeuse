package org.example.lawn;

public class RectangularLawn implements Lawn{
    private final int maxX;
    private final int maxY;

    public RectangularLawn(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    @Override
    public boolean isInside(int x, int y) {
        return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
    }

    @Override
    public void displayLimits() {
        System.out.println("Rectangular Lawn limits: maxX = " + maxX + ", maxY = " + maxY);
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
}
