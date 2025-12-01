package org.aoc23.days;

import org.aoc.day.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5 extends Day {
    private List<Long> seeds = new ArrayList<>();
    private List<ConversionMap> maps = new ArrayList<>();

    @Override
    public String partOne() {
        parseInput();
        var lowestLocation = 999999999999999999L;
        for (var seed : seeds) {
            var loc = seed;
            for (var map : maps) {
                loc = map.convert(loc);
            }
            if (loc < lowestLocation) lowestLocation = loc;
        }
        return String.valueOf(lowestLocation);
    }

    @Override // TODO this doesn't work
    public String partTwo() {
        if (this.seeds.isEmpty()) parseInput();
        var lowestLocation = 999999999999999999L;
        for (int i = 0; i < seeds.size(); i+=2) {
            for (long j = seeds.get(i); j < seeds.get(i) + seeds.get(i + 1); j++) {
                var loc = j;
                for (var map : maps) {
                    loc = map.convert(loc);
                }
                if (loc < lowestLocation) {
                    System.out.printf("new low: %s\n", loc);
                    lowestLocation = loc;
                }
            }
        }
        return String.valueOf(lowestLocation);
    }

    private void parseInput() {
        System.out.println("Reminder: add extra blank line to input.txt for correct parsing");
        ConversionMap currentMap = null;
        List<Range> currentRanges = new ArrayList<>();
        for (var line : this.input) {
            if (line.startsWith("seeds")) {
                Arrays.stream(line.split(": ")[1].split(" "))
                        .forEach(seed -> this.seeds.add(Long.parseLong(seed)));
            } else if (line.isBlank() && currentMap != null) {
                currentMap.setRanges(currentRanges);
                this.maps.add(currentMap);
            } else if (line.contains("map")) {
                currentMap = new ConversionMap(line);
                currentRanges = new ArrayList<>();
            } else if (!line.isBlank()) {
                currentRanges.add(new Range(line));
            }
        }
    }

    private static class Range {
        private long destinationStart;
        private long sourceStart;
        private long rangeLength;

        private Range(String line) {
            var split = line.split("\\s+");
            this.destinationStart = Long.parseLong(split[0]);
            this.sourceStart = Long.parseLong(split[1]);
            this.rangeLength = Long.parseLong(split[2]);
        }

        boolean isInRange(long source) {
            return source >= sourceStart && source <= sourceStart + rangeLength;
        }

        long getDestination(long source) {
            if (isInRange(source)) {
                return destinationStart + (source - sourceStart);
            }
            throw new IllegalArgumentException("not in range");
        }
    }

    private static class ConversionMap {
        private List<Range> ranges;
        private String mapType;

        ConversionMap(String name) {
            this.mapType = name;
        }

        ConversionMap setRanges(List<Range> ranges) {
            this.ranges = ranges;
            return this;
        }

        long convert(long source) {
            for (var range : ranges) {
                if (range.isInRange(source)) {
                    return range.getDestination(source);
                }
            }
            return source;
        }
    }
}
