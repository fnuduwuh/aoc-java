package org.aoc25.days;

import org.aoc.day.Day;

public class Day2 extends Day {
    @Override
    public String partOne() {
        return "";
    }

    @Override
    public String partTwo() {
        return "";
    }

    public boolean checkSymmetry(String id) {
        return id.substring(0, id.length()/2).equalsIgnoreCase(id.substring(id.length() / 2));
    }
}
