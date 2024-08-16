package day4;

import java.util.*;

public class Room {

    private String room;
    private HashMap<String, Integer> lettersInName = new HashMap<>();
    private int id;
    private String checksum;
    private int indexStartOfId;
    private int indexEndOfId;
    private String[] allCharacters;
    private boolean valid;

    public Room(String room) {
        this.room = room;
        allCharacters = room.split("");
        setStartIndexForId();
        setId();
        parseName();
        this.valid = checkRoomIsValid();
        System.out.println("Done");
    }

    public boolean isValid() {
        return this.valid;
    }

    public int getId() {
        return this.id;
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
        private void setId () {
            for (int i = 0; i < allCharacters.length; i++) {
                if (allCharacters[i].equalsIgnoreCase("[")) {
                    indexEndOfId = i;
                    this.id = Integer.parseInt(room.substring(indexStartOfId, indexEndOfId));
                    this.checksum = room.substring(i + 1, i + 6);
                    return;
                }
            }
        }

        private void setStartIndexForId () {
            for (int i = 0; i < allCharacters.length; i++) {
                if (isNumeric(allCharacters[i])) {
                    indexStartOfId = i;
                    return;
                }
            }
        }

        private boolean isNumeric (String toCheck){
            try {
                Integer.parseInt(toCheck);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
    }
