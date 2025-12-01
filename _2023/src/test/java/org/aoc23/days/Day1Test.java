package org.aoc23.days;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {
    Day1 day1 = new Day1();

    @BeforeEach
    void setup() {

    }

    @Test
    void partOne() {        
        day1.setInput(List.of("1abc2",
            "pqr3stu8vwx",
            "a1b2c3d4e5f",
            "treb7uchet"));
        assertEquals("142", day1.partOne());
    }

    @Test
    void partTwo() {
        day1.setInput(List.of("two1nine",
                "eightwothree",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "7pqrstsixteen"));
        assertEquals("281", day1.partTwo());
    }

    @Test
    void getFirstAndLastDigitJoined() {
        assertEquals(12, day1.getFirstAndLastDigitJoined(day1.getInput().getFirst()));
        assertEquals(38, day1.getFirstAndLastDigitJoined(day1.getInput().get(1)));
        assertEquals(15, day1.getFirstAndLastDigitJoined(day1.getInput().get(2)));
        assertEquals(77, day1.getFirstAndLastDigitJoined(day1.getInput().getLast()));
    }

    @Test
    void getFirstAndLastDigitJoinedIncludingWrittenNumers() {
        day1.setInput(List.of("two1nine",
                "eightwothree",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "7pqrstsixteen"));
        assertEquals(29, day1.getFirstAndLastDigitJoinedIncludingWrittenNumers("two1nine"));
        assertEquals(83, day1.getFirstAndLastDigitJoinedIncludingWrittenNumers("eightwothree"));
        assertEquals(13, day1.getFirstAndLastDigitJoinedIncludingWrittenNumers("abcone2threexyz"));
        assertEquals(76, day1.getFirstAndLastDigitJoinedIncludingWrittenNumers("7pqrstsixteen"));
    }
}