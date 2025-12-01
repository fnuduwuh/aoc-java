package org.aoc23.days;

import org.aoc.day.Day;

import java.util.LinkedHashMap;
import java.util.Map;

public class Day6 extends Day {
    final Map<Long, Long> races = new LinkedHashMap<>();

    @Override
    public String partOne() {
        parseInput();
        var result = 1L;
        for (var race : races.entrySet()) {
            result *= solveRace(race.getKey(), race.getValue());
        }
        return String.valueOf(result);
    }

    @Override
    public String partTwo() {
        if (races.isEmpty()) parseInput();
        String time = races.keySet().stream().map(String::valueOf).reduce("", String::concat);
        String distance = races.values().stream().map(String::valueOf).reduce("", String::concat);
        return String.valueOf(solveRace(Long.parseLong(time), Long.parseLong(distance)));
    }

    public boolean beatsRecord(long holdDown, long totalTime, long record) {
        return holdDown * (totalTime - holdDown) > record;
    }

    public long solveRace(long time, long distance) {
        long lowest = 0;
        for (int i = 0; i < time; i++) {
            if (beatsRecord(i, time, distance)) {
                lowest = i;
                break;
            }
        }
        long highest = 0;
        for (long i = time; i > 0; i--) {
            if (beatsRecord(i, time, distance)) {
                highest = i;
                break;
            }
        }
        return 1 + highest - lowest;
    }

    private void parseInput() {
        final var times = this.input.getFirst().split(":\\s+")[1].split("\\s+");
        final var distances = this.input.getLast().split(":\\s+")[1].split("\\s+");
        for (int i = 0; i < times.length; i++) {
            races.put(Long.valueOf(times[i]), Long.valueOf(distances[i]));
        }
    }
}
