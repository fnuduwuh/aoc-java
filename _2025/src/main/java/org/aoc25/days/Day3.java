package org.aoc25.days;

import org.aoc.day.Day;

public class Day3 extends Day {
    @Override
    public String partOne() {
        var total = 0;
        for (var bank : this.input) {
            var highest = "0";
            var joltage = "";
            var batteries = bank.split("");
            for (int i = 0; i < batteries.length; i++) {
                if (higherThan(batteries[i], highest) && i < batteries.length-1) {
                    highest = batteries[i];
                    joltage = highest;
                } else if (higherThan(highest + batteries[i], joltage)) {
                    joltage = highest + batteries[i];
                }
            }
            total += Integer.parseInt(joltage);
        }
        return String.valueOf(total);
    }

    @Override
    public String partTwo() {
        return "";
    }

    private boolean higherThan(String number1, String number2) {
        return Integer.parseInt(number1) > Integer.parseInt(number2);
    }
}
