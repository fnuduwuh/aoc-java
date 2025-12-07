package org.aoc25.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day3Test {
    Day3 day3 = new Day3();

    @BeforeEach
    void setUp() {
        day3.setInput(List.of("987654321111111",
                "811111111111119",
                "234234234234278",
                "818181911112111"));
    }

    @Test
    void partOne() {
        assertEquals("357", day3.partOne());
    }

    @Test
    void partTwo() {
    }
}