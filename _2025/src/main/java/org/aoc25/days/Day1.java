package org.aoc25.days;

import org.aoc.day.Day;

public class Day1 extends Day {
    @Override
    public String partOne() {
        var dial = 50;
        var timesExactlyZero = 0;
        for (var line : this.input) {
            var amountOfClicks = Integer.parseInt(line.substring(1));
            dial = line.substring(0,1).equalsIgnoreCase("L")
                    ? dial - amountOfClicks
                    : dial + amountOfClicks;
            dial %= 100;
            if (dial == 0) timesExactlyZero++;
        }
        return String.valueOf(timesExactlyZero);
    }

    @Override
    public String partTwo() {
        var dial = 50;
        var timesPastZero = 0;
        for (var line : this.input) {
            var direction = line.substring(0, 1);
            var amountOfClicks = Integer.parseInt(line.substring(1));
            if (amountOfClicks > 100) {
                timesPastZero += amountOfClicks / 100;
                amountOfClicks %= 100;
            }
            if (direction.equalsIgnoreCase("L")) {
                if (dial - amountOfClicks <= 0 && dial != 0) {
                    timesPastZero++;
                }
                dial = dial - amountOfClicks < 0 ? dial - amountOfClicks + 100 : dial - amountOfClicks;
            } else {
                if (dial + amountOfClicks > 99) {
                    timesPastZero++;
                }
                dial = (dial + amountOfClicks) % 100;
            }
        }
        return String.valueOf(timesPastZero);
    }
}
