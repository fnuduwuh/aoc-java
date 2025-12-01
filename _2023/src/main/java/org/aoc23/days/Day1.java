package org.aoc23.days;

import org.aoc.day.Day;
import org.aoc.helpers.StringHelper;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Day1 extends Day {

    public String partOne() {
        var total = 0;
        for (String line : this.input) {
            total += getFirstAndLastDigitJoined(line);
        }
        return String.valueOf(total);
    }

    public String partTwo() {
        var total = 0;
        for (String line : this.input) {
            total += getFirstAndLastDigitJoinedIncludingWrittenNumers(line);
        }
        return String.valueOf(total);
    }

    public int getFirstAndLastDigitJoined(String line) {
        List<String> characters = Arrays.stream(line.split("")).toList();
        var firstDigit = characters.stream().filter(StringHelper::isNumeric).findFirst().orElseThrow();
        var lastDigit = characters.reversed().stream().filter(StringHelper::isNumeric).findFirst().orElseThrow();
        return Integer.parseInt(String.format("%s%s", firstDigit, lastDigit));
    }

    public int getFirstAndLastDigitJoinedIncludingWrittenNumers(String line) {
        Pattern pattern = Pattern.compile("\\d|one|two|three|four|five|six|seven|eight|nine|eno|owt|eerht|ruof|evif|xis|neves|thgie|enin");
        var firstDigit = StringHelper.getSubstringBasedOnRegex(line, pattern);
        var lastDigit = StringHelper.getSubstringBasedOnRegex(StringHelper.reverseString(line), pattern);
        return Integer.parseInt(String.format("%s%s",
                StringHelper.getNumberStringAsInt(firstDigit),
                StringHelper.getNumberStringAsInt(StringHelper.reverseString(lastDigit))));
    }

}
