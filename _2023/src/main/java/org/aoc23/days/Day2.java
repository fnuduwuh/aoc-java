package org.aoc23.days;

import org.aoc.day.Day;
import org.aoc.helpers.StringHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Day2 extends Day {
    private Map<Integer, List<String>> games = new HashMap<>();

    @Override
    public String partOne() {
        var total = 0;
        processGames();
        for (var game : games.entrySet()) {
            if (isGamePossible(game.getValue())) {
                total += game.getKey();
            }
        }
        return String.valueOf(total);
    }

    @Override
    public String partTwo() {
        var total = 0;
        if (games.isEmpty()) {
            processGames();
        }
        for (var game : games.entrySet()) {
            total += getPowerOfGame(game.getValue());
        }
        return String.valueOf(total);
    }

    private void processGames() {
        for (String line : this.input) {
            String[] splitLine = line.split(": ");
            String id = StringHelper.getSubstringBasedOnRegex(splitLine[0], Pattern.compile("\\d+"));
            List<String> draws = Arrays.stream(splitLine[1].split("; ")).toList();
            games.put(Integer.parseInt(id), draws);
        }
    }

    private int getPowerOfGame(List<String> draws) {
        var blue = 0;
        var red = 0;
        var green = 0;
        for (String draw : draws) {
            var counts = draw.split(", ");
            for (String count : counts) {
                var countSplit = count.split(" ");
                var number = Integer.parseInt(countSplit[0]);
                switch (countSplit[1]) {
                    case "blue" -> blue = Math.max(number, blue);
                    case "red" -> red = Math.max(number, red);
                    case "green" -> green = Math.max(number, green);
                }
            }
        }
        return blue * red * green;
    }

    private boolean isGamePossible(List<String> draws) {
        for (String draw : draws) {
            var counts = draw.split(", ");
            for (String count : counts) {
                var countSplit = count.split(" ");
                var blue = 0;
                var red = 0;
                var green = 0;
                switch (countSplit[1]) {
                    case "blue" -> blue += Integer.parseInt(countSplit[0]);
                    case "red" -> red += Integer.parseInt(countSplit[0]);
                    case "green" -> green += Integer.parseInt(countSplit[0]);
                }
                if (blue > 14 || red > 12 || green > 13) {
                    return false;
                }
            }
        }
        return true;
    }
}
