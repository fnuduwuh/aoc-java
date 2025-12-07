package org.aoc25.days;

import org.aoc.day.Day;

import java.util.ArrayList;
import java.util.List;

public class Day6 extends Day {
    @Override
    public String partOne() {
        List<List<Integer>> numbersToMathWith = new ArrayList<>();
        List<String> operations = new ArrayList<>();
        for (var line : this.input) {
            List<Integer> numbers = new ArrayList<>();
            for (var value : line.trim().split("\\s+")) {
                if (this.input.indexOf(line) == this.input.size() - 1) {
                    operations.add(value);
                } else {
                    numbers.add(Integer.parseInt(value));
                }
            }
            if (!numbers.isEmpty()) numbersToMathWith.add(numbers);
        }

        var totalTotal = 0L;
        for (int i = 0; i < operations.size(); i++) {
            var total = 0L;
            for (var list : numbersToMathWith) {
                var number = list.get(i);
                if (operations.get(i).equalsIgnoreCase("*")) {
                    total = total == 0L ? number : total * number;
                } else {
                    total += number;
                }
            }
            totalTotal += total;
        }
        return String.valueOf(totalTotal);
    }

    @Override
    public String partTwo() {
        return "";
    }
}
