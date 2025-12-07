package org.aoc25.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6Test {
    Day6 day6 = new Day6();

    @BeforeEach
    void setUp() {
        day6.setInput(List.of(
                "123 328  51 64 ",
                " 45 64  387 23 ",
                "  6 98  215 314",
                "*   +   *   + "
        ));
    }

    @Test
    void partOne() {
        assertEquals("4277556", day6.partOne());
    }

    @Test
    void partTwo() {
    }
}