package org.aoc25.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day5Test {
    Day5 day5 = new Day5();

    @BeforeEach
    void setUp() {
        day5.setInput(List.of(
                "3-5",
                        "10-14",
                        "16-20",
                        "12-18",
                        "",
                        "1",
                        "5",
                        "8",
                        "11",
                        "17",
                        "32"
        ));
    }

    @Test
    void partOne() {
        assertEquals("3", day5.partOne());
    }

    @Test
    void partTwo() {
        assertEquals("14", day5.partTwo());
    }
}