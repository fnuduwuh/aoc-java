package org.aoc25.days;

import org.aoc.day.Day;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Day7 extends Day {

    @Override
    public String partOne() {
        final List<List<String>> grid = this.input.stream().map(line -> Arrays.stream(line.split("")).toList()).toList();
        var currentPositions = new HashSet<Point>();
        var timesSplit = 0;
        currentPositions.add(new Point(grid.getFirst().indexOf("S"), 0));
        try {
            for (int i = 0; i < grid.size(); i++) {
                int finalI = i;
                var tempList = new ArrayList<>(currentPositions.stream().filter(position -> position.y == finalI).toList());
                for (var position : tempList) {
                    if (grid.get(position.y + 1).get(position.x).equalsIgnoreCase("^")) {
                        currentPositions.add(new Point(position.x + 1, position.y + 1));
                        currentPositions.add(new Point(position.x - 1, position.y + 1));
                        timesSplit++;
                    } else {
                        currentPositions.add(new Point(position.x, position.y + 1));
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return String.valueOf(timesSplit);
        }
        return "";
    }

    @Override
    public String partTwo() {
        String[][] grid = new String[this.input.size()][this.input.getFirst().length()];
        for (int i = 0; i < this.input.size(); i++) {
            grid[i] = this.input.get(i).split("");
        }
        grid[0][this.input.getFirst().indexOf("S")] = "1";

        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].equalsIgnoreCase("^") && !grid[i - 1][j].equalsIgnoreCase(".")) {
                    var left = grid[i][j - 1];
                    var right = grid[i][j + 1];
                    if (!left.equalsIgnoreCase(".")) {
                        grid[i][j - 1] = String.valueOf(Long.parseLong(grid[i - 1][j]) + Long.parseLong(grid[i][j - 1]));
                    } else {
                        grid[i][j - 1] = String.valueOf(Long.parseLong(grid[i - 1][j]));
                    }
                    if (!right.equalsIgnoreCase(".")) {
                        grid[i][j + 1] = String.valueOf(Long.parseLong(grid[i - 1][j]) + Long.parseLong(grid[i][j + 1]));
                    } else {
                        grid[i][j + 1] = String.valueOf(Long.parseLong(grid[i - 1][j]));
                    }
                }
            }
            propagateDown(grid, i);
        }
        return String.valueOf(Arrays.stream(grid[grid.length - 1]).filter(el -> !el.equalsIgnoreCase(".")).mapToLong(Long::parseLong).sum());
    }

    private void propagateDown(String[][] grid, int index) {
        for (int i = 0; i < grid[index].length; i++) {
            if (!grid[index][i].equalsIgnoreCase("^") && !grid[index + 1][i].equalsIgnoreCase("^")) {
                grid[index + 1][i] = grid[index][i];
            }
        }
    }
}
