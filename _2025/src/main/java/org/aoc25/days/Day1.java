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

            // First calculate possible full rotations
            if (amountOfClicks > 100) timesPastZero += amountOfClicks / 100;
            // Use remainder of amountOfClicks to determine if zero or 99 is passed (again)
            amountOfClicks %= 100;

            if (direction.equalsIgnoreCase("L")) {
                timesPastZero += leftPastZero(dial, amountOfClicks);
                dial -= amountOfClicks;
            } else {
                timesPastZero += rightPastZero(dial, amountOfClicks);
                dial += amountOfClicks;
            }

            // Use remainder operation to correct for position if zero or 99 was passed
            dial = ((dial % 100) + 100) % 100;
        }
        return String.valueOf(timesPastZero);
    }

    private int leftPastZero(int dial, int clicks) {
        return dial - clicks <= 0 && dial != 0 ? 1 : 0;
    }

    private int rightPastZero(int dial, int clicks) {
        return dial + clicks > 99 ? 1 : 0;
    }
}
