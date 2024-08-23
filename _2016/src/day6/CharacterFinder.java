package day6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterFinder {
    private final List<String> lines;
    private final StringBuilder errorCorrectedMessage = new StringBuilder();
    private final StringBuilder errorCorrectedMessagePart2 = new StringBuilder();

    public CharacterFinder(List<String> lines) {
        this.lines = lines;
    }

    public void findMostAndLeastCommonCharacters() {
        int numberOfColumns = lines.getFirst().length();

        for (int i = 0; i < numberOfColumns; i++) {
            int maxOccurences = 0;
            Map<String, Integer> columnCharacters = new HashMap<>();
            for (int j = 0; j < lines.size(); j++) {
                String character = String.valueOf(lines.get(j).charAt(i));
                if (columnCharacters.containsKey(character)) {
                    columnCharacters.put(character, columnCharacters.get(character) + 1);
                } else {
                    columnCharacters.put(character, 1);
                }

                if (columnCharacters.get(character) > maxOccurences) {
                    maxOccurences = columnCharacters.get(character);
                }

            }

            String leastOccuringChar = "";
            int leastOccurences = maxOccurences;
            for (Map.Entry<String, Integer> entry : columnCharacters.entrySet()) {
                if (entry.getValue() == maxOccurences) {
                    errorCorrectedMessage.append(entry.getKey());
                } else if (entry.getValue() < leastOccurences) {
                    leastOccurences = entry.getValue();
                    leastOccuringChar = entry.getKey();
                }
            }
            errorCorrectedMessagePart2.append(leastOccuringChar);
        }
    }
    public void printErrorCorrectedMessage() {
        System.out.println(this.errorCorrectedMessage);
        System.out.println(this.errorCorrectedMessagePart2);
    }
}
