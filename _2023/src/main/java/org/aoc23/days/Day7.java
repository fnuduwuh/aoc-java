package org.aoc23.days;

import org.aoc.day.Day;
import org.aoc23.days.day7.Hand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day7 extends Day {
    private List<Hand> hands = new ArrayList<>();

    @Override
    public String partOne() {
        var total = 0;
        for (var line : this.input) {
            this.hands.add(new Hand(line));
        }
        int rank = this.hands.size();
        this.hands = this.hands.stream().sorted(Hand::compareTo).collect(Collectors.toList());
        for (var hand : this.hands) {
            total += hand.getBid() * rank;
            rank --;
        }
        return String.valueOf(total);
    }

    @Override
    public String partTwo() {
        this.hands.clear();
        var total = 0;
        for (var line : this.input) {
            this.hands.add(new Hand(line, true));
        }
        int rank = this.hands.size();
        this.hands = this.hands.stream().sorted(Hand::compareTo).collect(Collectors.toList());
        for (var hand : this.hands) {
            System.out.println(hand.getCards() + " " + hand.getType());
            total += hand.getBid() * rank;
            rank --;
        }
        return String.valueOf(total);
    }

}
