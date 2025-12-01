package org.aoc23.days;

import org.aoc.day.Day;
import org.aoc.helpers.GridHelper;
import org.aoc.helpers.StringHelper;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Day3 extends Day {

    @Override
    public String partOne() {
        var total = 0;
        var symbols = new ArrayList<Point>();
        var numbers = new ArrayList<Number>();
        for (int y = 0; y < this.input.size(); y++) {
            var split = Arrays.stream(this.input.get(y).split("")).toList();
            StringBuilder number = new StringBuilder();
            for (int j = 0; j < split.size(); j++) {
                var character = split.get(j);
                if (!StringHelper.isNumeric(character) && !character.equals(".")) {
                    symbols.add(new Point(j, y));
                    if (!number.isEmpty()) {
                        numbers.getLast().endIndex = j;
                        numbers.getLast().value = number.toString();
                        number = new StringBuilder();
                    }
                } else if ((character.equals(".") || j == split.size() - 1) && !number.isEmpty()) {
                    if (StringHelper.isNumeric(character)) number.append(character);
                    numbers.getLast().endIndex = j;
                    numbers.getLast().value = number.toString();
                    number = new StringBuilder();
                } else if (StringHelper.isNumeric(character)) {
                    if (number.isEmpty()) numbers.add(new Number(y, j));
                    number.append(character);
                }
            }
        }
        var numbersFiltered = numbers.stream().filter(n -> checkAdjacency(n, symbols)).map(Number::getValue).toList();
        total = numbersFiltered.stream().mapToInt(x -> x).sum();

        return String.valueOf(total);
    }


    private boolean checkAdjacency(Number number, ArrayList<Point> symbols) {
        for (int i = number.startIndex; i < number.endIndex; i++) {
            int finalI = i;
            boolean match = symbols.stream().anyMatch(symbol -> GridHelper.isAdjacentTo(symbol.x, symbol.y, finalI, number.row));
            if (match) return true;
        }
        return false;
    }

    private boolean checkAdjacency(Number number, Point gear) {
        for (int i = number.startIndex; i < number.endIndex; i++) {
            boolean match = GridHelper.isAdjacentTo(gear.x, gear.y, i, number.row);
            if (match) return true;
        }
        return false;
    }

    @Override
    public String partTwo() {
        var total = 0;
        var possibleGears = new ArrayList<Point>();
        var numbers = new ArrayList<Number>();
        for (int y = 0; y < this.input.size(); y++) {
            var split = Arrays.stream(this.input.get(y).split("")).toList();
            StringBuilder number = new StringBuilder();
            for (int j = 0; j < split.size(); j++) {
                var character = split.get(j);
                if (!StringHelper.isNumeric(character) && character.equals("*")) {
                    possibleGears.add(new Point(j, y));
                    if (!number.isEmpty()) {
                        numbers.getLast().endIndex = j;
                        numbers.getLast().value = number.toString();
                        number = new StringBuilder();
                    }
                } else if ((character.equals(".") || j == split.size() - 1) && !number.isEmpty()) {
                    if (StringHelper.isNumeric(character)) number.append(character);
                    numbers.getLast().endIndex = j;
                    numbers.getLast().value = number.toString();
                    number = new StringBuilder();
                } else if (StringHelper.isNumeric(character)) {
                    if (number.isEmpty()) numbers.add(new Number(y, j));
                    number.append(character);
                }
            }
        }
        for (var gear : possibleGears) {
            var adjacent = numbers.stream().filter(n -> checkAdjacency(n, gear)).map(Number::getValue).toList();
            if (adjacent.size() == 2) {
                total += adjacent.getFirst() * adjacent.getLast();
            }
        }
        return String.valueOf(total);
    }

    static class Number {
        int row;
        int startIndex;
        int endIndex;
        String value;

        Number(int row, int startIndex) {
            this.row = row;
            this.startIndex = startIndex;
        }

        int getValue() {
            return Integer.parseInt(this.value);
        }

    }
}
