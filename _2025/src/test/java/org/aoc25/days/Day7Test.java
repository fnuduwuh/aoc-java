package org.aoc25.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day7Test {
    Day7 day7 = new Day7();

    @BeforeEach
    void setUp() {
        day7.setInput(List.of(
                ".......S.......",
                        "...............",
                        ".......^.......",
                        "...............",
                        "......^.^......",
                        "...............",
                        ".....^.^.^.....",
                        "...............",
                        "....^.^...^....",
                        "...............",
                        "...^.^...^.^...",
                        "...............",
                        "..^...^.....^..",
                        "...............",
                        ".^.^.^.^.^...^.",
                        "..............."
        ));
    }

    @Test
    void partOne() {
        assertEquals("21", day7.partOne());
    }

    @Test
    void partTwo() {
        assertEquals("40", day7.partTwo());
    }
}