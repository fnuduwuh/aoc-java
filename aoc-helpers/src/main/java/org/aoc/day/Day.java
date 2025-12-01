package org.aoc.day;

import lombok.Getter;
import lombok.Setter;
import org.aoc.helpers.InputHelper;

import java.util.List;

@Getter
@Setter
public abstract class Day {
    protected List<String> input;

    public Day() {
        this.input = InputHelper.getInputAsListOfLines();
    }

    public void printSolutions() {
        System.out.printf("Printing solutions for %s:\n", this.getClass().getSimpleName());
        System.out.printf("Part one: %s\n", this.partOne());
        System.out.printf("Part two: %s\n", this.partTwo());

    }

    public abstract String partOne();
    public abstract String partTwo();
}
