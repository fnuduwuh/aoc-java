package org.aoc25.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day4Test {
    Day4 day4 = new Day4();

    @BeforeEach
    void setUp() {
        day4.setInput(List.of(
                "..@@.@@@@.",
                "@@@.@.@.@@",
                "@@@@@.@.@@",
                "@.@@@@..@.",
                "@@.@@@@.@@",
                ".@@@@@@@.@",
                ".@.@.@.@@@",
                "@.@@@.@@@@",
                ".@@@@@@@@.",
                "@.@.@@@.@."));
    }

    @Test
    void partOne() {
        assertEquals("13", day4.partOne());
    }

    @Test
    void partTwo() {
    }
}
