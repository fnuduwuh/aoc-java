package org.aoc25.days;

import org.aoc.day.Day;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day4 extends Day {
    @Override
    public String partOne() {
        var mappedRolls = new HashMap<Point2D, Integer>();
        final var twoDArray = new ArrayList<String[]>();
        for (var line : input) {
            twoDArray.add(line.split(""));
        }
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).length(); j++) {
                if (twoDArray.get(i)[j].equalsIgnoreCase("@")) {
                    mappedRolls.put(new Point(i, j), 0);
                }
            }
        }
        for (var roll : mappedRolls.keySet()) {
            updateAdjacentRolls(roll, mappedRolls);
        }

        return String.valueOf(mappedRolls.entrySet().stream().filter(roll -> roll.getValue() < 4).count());
    }

    @Override
    public String partTwo() {
        return "";
    }

    private void updateAdjacentRolls(Point2D currentRoll, HashMap<Point2D, Integer> rolls) {
        final var currentX = currentRoll.getX();
        final var currentY = currentRoll.getY();
        List<Point2D> adjacentPoints = List.of(
                new Point2D.Double(currentX - 1, currentY),
                new Point2D.Double(currentX + 1, currentY),
                new Point2D.Double(currentX - 1, currentY - 1),
                new Point2D.Double(currentX - 1, currentY + 1),
                new Point2D.Double(currentX, currentY - 1),
                new Point2D.Double(currentX, currentY + 1),
                new Point2D.Double(currentX + 1, currentY + 1),
                new Point2D.Double(currentX + 1, currentY - 1)
        );
        for (var adjacentPoint : adjacentPoints) {
            if (rolls.containsKey(adjacentPoint)) {
                rolls.put(adjacentPoint, rolls.get(adjacentPoint) + 1);
            }
        }
    }
}
