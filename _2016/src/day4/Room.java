package day4;

import utils.StringHelper;

import java.util.*;

import static utils.StringHelper.ALPHABET_LIST;

public class Room {

    private final HashMap<String, Integer> lettersInName = new HashMap<>();
    private final int indexStartOfId;
    private final String[] allCharacters;
    private final boolean valid;
    private final String room;
    private int id;
    private String checksum;

    public Room(String room) {
        this.room = room;
        allCharacters = room.split("");
        indexStartOfId = getStartIndexForId();
        setIdAndChecksum();
        parseName();
        this.valid = checkRoomIsValid();
    }

    public boolean isValid() {
        return this.valid;
    }

    public int getId() {
        return this.id;
    }

    public String getDecryptedName() {
        int placesForward = this.id % 26;
        StringBuilder decryptedName = new StringBuilder();
        for (int i = 0; i < indexStartOfId; i++) {
            String character = allCharacters[i];
            if (character.equalsIgnoreCase("-")) {
                decryptedName.append(" ");
            } else {
                int alphabetIndex = ALPHABET_LIST.indexOf(character) + placesForward;
                alphabetIndex = alphabetIndex > 25 ? alphabetIndex - 26 : alphabetIndex;
                decryptedName.append(ALPHABET_LIST.get(alphabetIndex));
            }
        }
        return decryptedName.toString();
    }

    private boolean checkRoomIsValid() {
        String[] checksumLetters = this.checksum.split("");
        List<Integer> occurences = new ArrayList<>(this.lettersInName.values().stream().toList());
        occurences.sort(Comparator.reverseOrder());

        for (int i = 0; i < checksumLetters.length; i++) {
            if (!Objects.equals(lettersInName.get(checksumLetters[i]), occurences.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void parseName() {
        for (int i = 0; i < this.indexStartOfId; i++) {
            String character = allCharacters[i];
            if (!character.equalsIgnoreCase("-")) {
                if (lettersInName.containsKey(character)) {
                    int count = lettersInName.get(character);
                    lettersInName.put(character, ++count);
                } else {
                    lettersInName.put(character, 1);
                }
            }
        }
    }

    private void setIdAndChecksum() {
        for (int i = indexStartOfId; i < allCharacters.length; i++) {
            if (allCharacters[i].equalsIgnoreCase("[")) {
                this.id = Integer.parseInt(room.substring(indexStartOfId, i));
                this.checksum = room.substring(i + 1, i + 6);
                return;
            }
        }
    }

    private int getStartIndexForId() {
        for (int i = 0; i < allCharacters.length; i++) {
            if (StringHelper.isNumeric(allCharacters[i])) {
                return i;
            }
        }
        throw new RuntimeException("No valid index found!");
    }
}
