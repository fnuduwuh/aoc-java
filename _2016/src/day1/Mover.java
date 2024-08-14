package day1;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Mover {
    private int y = 0;
    private int x = 0;
    private Direction direction = Direction.NORTH;
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
                case NORTH -> direction = Direction.WEST;
                case EAST -> direction = Direction.NORTH;
                case SOUTH -> direction = Direction.EAST;
                case WEST -> direction = Direction.SOUTH;
            }
        } else if (dir.equalsIgnoreCase("R")) {
            switch (direction) {
                case NORTH -> direction = Direction.EAST;
                case EAST -> direction = Direction.SOUTH;
                case SOUTH -> direction = Direction.WEST;
                case WEST -> direction = Direction.NORTH;
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
