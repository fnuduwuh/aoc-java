package org.aoc25.days;

import org.aoc.day.Day;

public class Day2 extends Day {
    @Override
    public String partOne() {
        final var ranges = this.input.getFirst().split(",");
        var symmetricalIds = 0L;
        for (var range : ranges) {
            var start = range.split("-")[0];
            var end = range.split("-")[1];
                for (long i = Long.parseLong(start); i <= Long.parseLong(end); i++) {
                    if (checkSymmetry(String.valueOf(i))) {
                        symmetricalIds+=i;
                    }
                }
        }
        return String.valueOf(symmetricalIds);
    }

    @Override
    public String partTwo() {
        final var ranges = this.input.getFirst().split(",");
        var symmetricalIds = 0L;
        for (var range : ranges) {
            var start = range.split("-")[0];
            var end = range.split("-")[1];
            for (long i = Long.parseLong(start); i <= Long.parseLong(end); i++) {
                if (checkSymmetry(String.valueOf(i))) { // TODO implement function to check all valid parts of id
                    symmetricalIds+=i;
                }
            }
        }
        return String.valueOf(symmetricalIds);
    }

    public boolean checkSymmetry(String id) {
        return id.substring(0, id.length()/2).equalsIgnoreCase(id.substring(id.length() / 2));
    }

    public boolean checkInvalidPartTwo(String id) {
        return false;
    }
}
