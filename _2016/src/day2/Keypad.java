package day2;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// TODO set Grid as field in class to be able to switch between parts.
// TODO move with try catch to catch outofbounds exception to generalize movement in different grids
public class Keypad {
    private final Point current;
    private final List<String> keys = new ArrayList<>();
    private final String[][] pad_pt1 = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
    private final String[][] pad_pt2 = {{"", "", "1", "", ""}, {"", "2", "3", "4", ""}, {"5", "6", "7", "8", "9"}, {"", "A", "B", "C", ""}, {"", "", "D", "", ""}};
    private String[][] pad;

    public Keypad(int part) {
        if (part == 2) {
            this.pad = pad_pt2;
            this.current = new Point(0, 2);
        } else {
            this.pad = pad_pt1;
            this.current = new Point(1, 1);
        }
    }

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
        try {
            switch (step) {
                case "U" -> moveUp();
                case "D" -> moveDown();
                case "L" -> moveLeft();
                case "R" -> moveRight();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("invalid");
        }
    }

    private void moveUp() {
        if (!pad[current.y - 1][current.x].isBlank()) {
            current.move(current.x, current.y - 1);
        }
    }

    private void moveDown() {
        if (!pad[current.y + 1][current.x].isBlank()) {
            current.move(current.x, current.y + 1);
        }
    }

    private void moveLeft() {
        if (!pad[current.y][current.x - 1].isBlank()) {
            current.move(current.x - 1, current.y);
        }
    }

    private void moveRight() {
        if (!pad[current.y][current.x + 1].isBlank()) {
            current.move(current.x + 1, current.y);
        }
    }

    private String getKeyForCoordinates() {
        int x = Double.valueOf(this.current.getX()).intValue();
        int y = Double.valueOf(this.current.getY()).intValue();

        return this.pad[y][x];
    }
}
