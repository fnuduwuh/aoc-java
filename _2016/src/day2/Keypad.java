package day2;

import java.awt.*;
import java.util.*;
import java.util.List;

// TODO set Grid as field in class to be able to switch between parts.
// TODO move with try catch to catch outofbounds exception to generalize movement in different grids
public class Keypad {
    private final Point current = new Point(1,1);
    private final List<String> keys = new ArrayList<>();
    private final String[][] pad = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};

    public void move(String[] steps) {
        for (String step : steps) {
            move(step);
        }
        keys.add(getKeyForCoordinates());
    }

    public String getKeys() {
        StringBuilder stringBuilder = new StringBuilder();
        this.keys.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    private void move(String step) {
        switch (step) {
            case "U" -> moveUp();
            case "D" -> moveDown();
            case "L" -> moveLeft();
            case "R" -> moveRight();
        }
    }

    private void moveUp() {
        if (current.getY() > 0) {
            current.move(current.x, current.y-1);
        }
    }
    private void moveDown() {
        if (current.getY() < 2) {
            current.move(current.x, current.y+1);
        }
    }
    private void moveLeft() {
        if (current.getX() > 0) {
            current.move(current.x-1, current.y);
        }
    }

    private void moveRight() {
        if (current.getX() < 2) {
            current.move(current.x+1, current.y);
        }
    }

    private String getKeyForCoordinates() {
        int x = Double.valueOf(this.current.getX()).intValue();
        int y = Double.valueOf(this.current.getY()).intValue();

        return this.pad[y][x];
    }
}
