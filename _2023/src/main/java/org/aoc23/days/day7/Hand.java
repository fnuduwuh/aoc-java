package org.aoc23.days.day7;

import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.aoc23.days.day7.HandType.*;

@Getter
public class Hand implements Comparable {
    private final int bid;
    private final List<String> cards;
    private final HandType type;
    private final boolean jokerRule;

    public Hand(String line) {
        this.jokerRule = false;
        this.bid = Integer.parseInt(line.split("\\s+")[1]);
        this.cards = Arrays.stream(line.split("\\s+")[0].split("")).toList();
        this.type = determineType();
    }

    public Hand(String line, boolean jokerRule) {
        this.jokerRule = jokerRule;
        this.bid = Integer.parseInt(line.split("\\s+")[1]);
        this.cards = Arrays.stream(line.split("\\s+")[0].split("")).toList();
        this.type = determineType();
    }

    public int compareTo(Object o) {
        final var otherHand = (Hand) o;
        if (otherHand.type.equals(this.type)) {
            for (int i = 0; i < 5; i++) {
                if (!this.cards.get(i).equals(otherHand.cards.get(i))) {
//                    var uno = getCardValue(this.cards.get(i));
//                    var due = getCardValue(otherHand.cards.get(i));
                    return getCardValue(this.cards.get(i)) > getCardValue(otherHand.cards.get(i)) ? -1 : 1;
                }
            }
            return 0;
        } else {
            return otherHand.type.ordinal() > this.type.ordinal() ? -1 : 1;
        }
    }

    public HandType determineType() {
        final Map<String, Integer> checkMap = new LinkedHashMap<>();
        for (var card : this.cards) {
            if (checkMap.containsKey(card)) {
                checkMap.put(card, checkMap.get(card) + 1);
            } else {
                checkMap.put(card, 1);
            }
        }
        return mapToType(checkMap);
    }

    private int getCardValue(String card) {
        return switch (card) {
            case "A" -> 14;
            case "K" -> 13;
            case "Q" -> 12;
            case "J" -> this.jokerRule ? 1 : 11;
            case "T" -> 10;
            default -> Integer.parseInt(card);
        };
    }

    private HandType mapToType(Map<String, Integer> cards) {
        var jokerValue = 0;
        if (this.jokerRule && cards.containsKey("J")) {
            if (cards.get("J") == 5) {
                return FIVE_OF_A_KIND;
            }
            jokerValue = cards.get("J");
            cards.remove("J");
        }
        var values = cards.values().stream().sorted().collect(Collectors.toList()).reversed();
//        var highestValue = values.isEmpty() ? 0 : values.getFirst();
        values.set(0, values.getFirst() + jokerValue);
        if (values.getFirst() >= 5) {
            return FIVE_OF_A_KIND;
        }
        if (values.getFirst() == 4) {
            return FOUR_OF_A_KIND;
        }
        if (values.getFirst() == 3) {
            return values.get(1) == 2 ? FULL_HOUSE : THREE_OF_A_KIND;
        }
        if (values.getFirst() == 2) {
            return values.get(1) == 2 ? TWO_PAIR : ONE_PAIR;
        }
        return HIGH_CARD;
    }
}
