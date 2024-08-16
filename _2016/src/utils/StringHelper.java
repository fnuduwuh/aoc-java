package utils;

import java.util.List;

public class StringHelper {

    public static List<String> ALPHABET_LIST = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");


    public static boolean isNumeric(String toCheck) {
        try {
            Integer.parseInt(toCheck);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
