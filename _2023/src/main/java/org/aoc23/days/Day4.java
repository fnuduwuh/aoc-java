package org.aoc23.days;

import org.aoc.day.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 extends Day {
    @Override
    public String partOne() {
        return String.valueOf(this.input.stream().map(line -> new Card(line).getScore()).mapToInt(c -> c).sum());
    }

    @Override
    public String partTwo() {
        var totalCopies = 0;
        List<Card> cards = this.input.stream().map(Card::new).toList();
        for (int i = 0; i < cards.size(); i++) {
            for (int x = 0; x < cards.get(i).copies; x++) {
                for (int j = 0; j < cards.get(i).getMatches(); j++) {
                    if (i + j + 1 < cards.size()) {
                        cards.get(i + j + 1).addCopy();
                    }
                }
            }
            totalCopies += cards.get(i).getCopies();
        }
        return String.valueOf(totalCopies);
    }

    private static class Card {
        private List<Integer> numbers = new ArrayList<>();
        private List<Integer> winningNumbers = new ArrayList<>();
        private int score = 0;
        private int copies = 1;
        private int matches = 0;

        Card(String cardInfo) {
            var numbers = cardInfo.split(":\\s+")[1].split("\\s+\\|\\s+")[0];
            var winningNumbers = cardInfo.split(":\\s+")[1].split("\\s+\\|\\s+")[1];
            for (var number : numbers.split("\\s+")) {
                this.numbers.add(Integer.parseInt(number));
            }
            for (var number : winningNumbers.split("\\s+")) {
                this.winningNumbers.add(Integer.parseInt(number));
            }

            calculateScore();
        }

        private void addCopy() {
            this.copies++;
        }

        private int getCopies() {
            return this.copies;
        }

        private int getMatches() {
            return this.matches;
        }

        private int getScore() {
            return this.score;
        }

        private void calculateScore() {
            for (var number : this.numbers) {
                if (winningNumbers.contains(number)) {
                    this.matches++;
                    if (this.score > 0) {
                        this.score *= 2;
                    } else {
                        this.score = 1;
                    }
                }
            }
        }
    }
}
