package day1;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static day1.Mover.Direction.*;

public class Mover {
    enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    private int y = 0;
    private int x = 0;
    private Direction direction = NORTH;
    private final List<Point> visited = new ArrayList<>();
    private Point firstVisitedTwice;


    public int getDistanceForFirstPointVisitedTwice() {
        int x = Double.valueOf(firstVisitedTwice.getX()).intValue();
        int y = Double.valueOf(firstVisitedTwice.getY()).intValue();
        return Math.abs(-x) + Math.abs(-y);
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public void changeDirection(String dir) {
        if (dir.equalsIgnoreCase("L")) {
            switch (direction) {
                case NORTH -> direction = WEST;
                case EAST -> direction = NORTH;
                case SOUTH -> direction = EAST;
                case WEST -> direction = SOUTH;
            }
        } else if (dir.equalsIgnoreCase("R")) {
            switch (direction) {
                case NORTH -> direction = EAST;
                case EAST -> direction = SOUTH;
                case SOUTH -> direction = WEST;
                case WEST -> direction = NORTH;
            }
        }
    }

    public void move(int steps) {
        for (int i = 0; i < steps; i++) {
            switch (direction) {
                case NORTH -> y -= 1;
                case EAST -> x += 1;
                case SOUTH -> y += 1;
                case WEST -> x -= 1;
            }
            Point point = new Point(this.x, this.y);
            if (visited.contains(point)) firstVisitedTwice = new Point(this.x, this.y);
            if (firstVisitedTwice == null) visited.add(point);
        }
    }
}
