package org.aoc23.days;

import org.aoc.helpers.GridHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day3Test {
    Day3 day3 = new Day3();

    @BeforeEach
    void setup() {
        day3.setInput(new ArrayList<>(List.of("467..114..",
                "...*......",
                "..35...633",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598..")));
    }

    @Test
    void partOne() {
        assertEquals("4361", day3.partOne());
        assertTrue(GridHelper.isAdjacentTo(0, 0, 0, 1));
        assertFalse(GridHelper.isAdjacentTo(0, 0, 2, 1));
        assertTrue(GridHelper.isAdjacentTo(0, 0, 1, 1));
    }

    @Test
    void partTwo() {
        assertEquals("467835", day3.partTwo());
    }
}