package org.aoc25.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {
    Day1 day1 = new Day1();

    @BeforeEach
    void setUp() {
        day1.setInput(
                List.of("L68",
                        "L30",
                        "R48",
                        "L5",
                        "R60",
                        "L55",
                        "L1",
                        "L99",
                        "R14",
                        "L82")
        );
    }

    @Test
    void partOne() {
        assertEquals("3", day1.partOne());
    }

    @Test
    void partTwo() {
        assertEquals("6", day1.partTwo());
    }
}