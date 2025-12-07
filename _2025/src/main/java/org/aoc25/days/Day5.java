package org.aoc25.days;

import org.aoc.day.Day;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day5 extends Day {
    @Override
    public String partOne() {
        var total = 0;
        List<Range> ranges = getRanges();

        for (int i = this.input.indexOf("")+1; i < this.input.size(); i++) {
            var ingredient = Long.parseLong(this.input.get(i));
            for (var range : ranges) {
                if (range.isInRange(ingredient)) {
                    total++;
                    break;
                }
            }
        }
        return String.valueOf(total);
    }

    @Override
    public String partTwo() {
        var ranges = getRanges();
        var ingredients = new HashSet<Long>();

        for (var range : ranges) {
            updateListWithRange(ingredients, range);
        }
        return String.valueOf(ingredients.size());
    }

    private void updateListWithRange(Set<Long> ingredients, Range range) {
        ingredients.addAll(range.getAllIngredients());
    }

    private List<Range> getRanges() {
        List<Range> ranges = new ArrayList<>();
        for (var line : this.input) {
            if (line.isBlank()) break;
            var start = Long.parseLong(line.split("-")[0]);
            var end = Long.parseLong(line.split("-")[1]);
            ranges.add(new Range(start, end));
        }
        return ranges;
    }

    static class Range {
        final long start;
        final long end;

        Range(long start, long end) {
            this.start = start;
            this.end = end;
        }

        boolean isInRange(long number) {
            return number >= start && number <= end;
        }

        List<Long> getAllIngredients() {
            var ingredients = new ArrayList<Long>();
            for (long i = start; i <= end; i++) {
                ingredients.add(i);
            }
            return ingredients;
        }
    }
}
