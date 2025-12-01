package org.aoc23.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day6Test {
    Day6 day6 = new Day6();

    @BeforeEach
    public void setup() {
        day6.setInput(List.of("Time:      7  15   30",
                "Distance:  9  40  200"));
    }

    @Test
    void beatsRecord() {
        assertTrue(day6.beatsRecord(2, 7, 9));
        assertFalse(day6.beatsRecord(1, 7, 9));
        assertFalse(day6.beatsRecord(6, 7, 9));
        assertFalse(day6.beatsRecord(7, 7, 9));
        assertTrue(day6.beatsRecord(5, 7, 9));
    }

    @Test
    void solveRace() {
        assertEquals(4, day6.solveRace(7,9));
    }

    @Test
    void partOne() {
        assertEquals("71503", day6.partTwo());
    }

    @Test
    void partTwo() {
    }
}