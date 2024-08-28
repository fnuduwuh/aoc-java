package day8;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LCD {
    private final String[][] screen;

    public LCD(int length, int height) {
        screen = new String[height][length];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                screen[i][j] = ".";
            }
        }
    }

    public void addRectangle(int length, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                screen[i][j] = "o";
            }
        }
    }

    public void rotateColumn(int column, int shifts) {
        Map<Point, Integer> points = new HashMap<>();
        for (int i = 0; i < screen.length; i++) {
            int newIndex = shifts + i >= screen.length ? i + shifts - screen.length : i + shifts;

            if (screen[i][column].equalsIgnoreCase("o")) {
                points.put(new Point(i, column), newIndex);
                screen[i][column] = ".";
            }
        }
        points.forEach((key, value) -> screen[value][key.y] = "o");
    }

    public void rotateRow(int row, int shifts) {
        Map<Point, Integer> points = new HashMap<>();
        for (int i = 0; i < screen[0].length; i++) {
            int newIndex = shifts + i >= screen[0].length ? i + shifts - screen[0].length : i + shifts;
            if (screen[row][i].equalsIgnoreCase("o")) {
                screen[row][i] = ".";
                points.put(new Point(row, i), newIndex);
            }
        }
        points.forEach((key, value) -> screen[key.x][value] = "o");
    }

    public int countPixels() {
        int pixels = 0;
        for (String[] rows : screen) {
            for (String cell : rows) {
                if (cell.equalsIgnoreCase("o")) {
                    pixels++;
                }
            }

        }
        return pixels;
    }

    public void printScreen() {
        for (int i = 0; i < screen.length; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < screen[i].length; j++) {
                line.append(screen[i][j]);
            }
            System.out.println(line);
        }
    }
}
