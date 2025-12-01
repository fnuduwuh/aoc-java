package org.aoc23.days;

import org.aoc23.days.day7.Hand;
import org.aoc23.days.day7.HandType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day7Test {
    Day7 day7 = new Day7();

    @BeforeEach
    void setUp() {
        day7.setInput(List.of("32T3K 765",
                "T55J5 684",
                "KK677 28",
                "KTJJT 220",
                "QQQJA 483"));
    }

    @Test
    void partOne() {
        assertEquals("6440", day7.partOne());
    }

    @Test
    void partTwo() {
        assertEquals("5905", day7.partTwo());
    }

    @Test
    void processHand() {
//        Hand testHand = new Hand("QQQJA 483");
//        assertEquals(483, testHand.getBid());
//        assertEquals(HandType.THREE_OF_A_KIND, testHand.getType());

        Hand fiveKind = new Hand("JJJJJ 100", true);
        Hand fiveKind2 = new Hand("2222J 100", true);
        assertEquals(HandType.FIVE_OF_A_KIND, fiveKind.getType());
        assertEquals(HandType.FIVE_OF_A_KIND, fiveKind2.getType());
        assertEquals(1, fiveKind.compareTo(fiveKind2));

        Hand fiveKind3 = new Hand("J8JJJ 100", true);
        assertEquals(HandType.FIVE_OF_A_KIND, fiveKind3.getType());
        assertEquals(1, fiveKind.compareTo(fiveKind3));
        assertEquals(1, fiveKind3.compareTo(fiveKind2));

        Hand fourKind = new Hand("333J5 100", true);
        assertEquals(HandType.FOUR_OF_A_KIND, fourKind.getType());

        Hand fourKind2 = new Hand("333J6 100", true);
        assertEquals(HandType.FOUR_OF_A_KIND, fourKind2.getType());
        assertEquals(1, fourKind.compareTo(fourKind2));

        Hand fullHouse = new Hand("9KKJ9 100", true);
        assertEquals(HandType.FULL_HOUSE, fullHouse.getType());
        Hand fullHouse2 = new Hand("9KK9J 100", true);
        assertEquals(HandType.FULL_HOUSE, fullHouse2.getType());
        assertEquals(1, fullHouse.compareTo(fullHouse2));
    }

    @Test
    void beats() {
        Hand testHand = new Hand("QQQJA 483");
        Hand betterHand = new Hand("QQQQJ 483");
        assertEquals(-1, betterHand.compareTo(testHand));

        Hand worseHand = new Hand("QQQJK 483");
        assertEquals(1, worseHand.compareTo(testHand));
    }

    @Test
    void debug() {

        Hand threeKind = new Hand("A8JJ7 100", true);
        assertEquals(HandType.THREE_OF_A_KIND, threeKind.getType());
    }
}