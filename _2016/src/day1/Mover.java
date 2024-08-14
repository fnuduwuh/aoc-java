package day1;

public class Mover {
    private int y = 0;
    private int x = 0;
    private Direction direction = Direction.NORTH;

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
        switch (direction) {
            case NORTH -> y -= steps;
            case EAST -> x += steps;
            case SOUTH -> y += steps;
            case WEST -> x -= steps;
        }
    }
}
