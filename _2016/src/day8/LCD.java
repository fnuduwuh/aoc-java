package day8;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCD {
    private String[][] screen;

    public LCD(int length, int height) {
        screen = new String[height][length];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                screen[i][j] = " ";
            }
        }
    }

    public void addRectangle(int length, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                screen[i][j] = "#";
            }
        }
    }

    public void rotateColumn(int column, int shifts) {
        Map<Point, Integer> points = new HashMap<>();
        for (int i = 0; i < screen.length; i++) {
            int newIndex = shifts + i >= screen.length ? i + shifts - screen.length : i + shifts;

            if (screen[i][column].equalsIgnoreCase("#")) {
                points.put(new Point(i, column), newIndex);
                screen[i][column] = " ";
            }
        }
        int finalShifts = shifts;
        points.forEach((key, value) -> screen[value][key.y] = "#");
    }

    public void rotateRow(int row, int shifts) {
        Map<Point, Integer> points = new HashMap<>();
        for (int i = 0; i < screen[0].length; i++) {
            int newIndex = shifts + i >= screen[0].length ? i + shifts - screen[0].length : i + shifts;
            if (screen[row][i].equalsIgnoreCase("#")) {
                screen[row][i] = " ";
                points.put(new Point(row, i), newIndex);
            }
        }
        int finalShifts = shifts;
        points.forEach((key, value) -> screen[key.x][value] = "#");
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
