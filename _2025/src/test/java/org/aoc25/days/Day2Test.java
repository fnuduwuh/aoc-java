package org.aoc25.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {
    Day2 day2 = new Day2();

    @BeforeEach
    void setUp() {
        day2.setInput(List.of("""
                11-22,95-115,998-1012,1188511880-1188511890,222220-222224,
                "1698522-1698528,446443-446449,38593856-38593862,565653-565659,
                "824824821-824824827,2121212118-2121212124
                """));
    }

    @Test
    void partOne() {
    }

    @Test
    void partTwo() {
    }

    @Test
    void checkSymmetry() {
        assertTrue(day2.checkSymmetry(("1010")));
        assertTrue(day2.checkSymmetry(("1188511885")));
        assertTrue(day2.checkSymmetry(("99")));
        assertFalse(day2.checkSymmetry(("98")));
        assertFalse(day2.checkSymmetry(("9")));
    }
}