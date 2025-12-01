package org.aoc.helpers;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {

    public static boolean isNumeric(String inputString) {
        Pattern pattern = Pattern.compile("\\d");
        return pattern.matcher(inputString).matches();
    }

    public static String reverseString(String inputString) {
        return String.join("", Arrays.stream(inputString.split("")).toList().reversed());
    }

    public static int getNumberStringAsInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return switch (number.toLowerCase()) {
                case "one" -> 1;
                case "two" -> 2;
                case "three" -> 3;
                case "four" -> 4;
                case "five" -> 5;
                case "six" -> 6;
                case "seven" -> 7;
                case "eight" -> 8;
                case "nine" -> 9;
                default -> throw new IllegalStateException("Unexpected value: " + number.toLowerCase());
            };
        }
    }

    public static String getSubstringBasedOnRegex(String inputString, Pattern pattern) {
        Matcher regexMatcher = pattern.matcher(inputString);
        if (regexMatcher.find()) {
            return regexMatcher.group(0);
        } else {
            throw new IllegalArgumentException(String.format("No match found for string [%s] pattern [%s]", inputString, pattern.pattern()));
        }
    }
}
