package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {
    private List<String> lines;
    public InputParser(String inputFilePath) {
        try {
            lines = Files.readAllLines(Paths.get(inputFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getLines() {
        return lines;
    }

    public List<String> getLinesSplitByComma() {
        List<String> splitted = new ArrayList<>();
        lines.forEach(line -> splitted.addAll(List.of(line.split(","))));
        return splitted.stream().map(String::trim).toList();
    }

    public List<String> getLinesSplitBy(String regex) {
        List<String> splitted = new ArrayList<>();
        lines.forEach(line -> splitted.addAll(List.of(line.split(regex))));
        return splitted.stream().map(String::trim).toList();
    }

    public static List<String> filterOutEmptyStrings(List<String> inputs) {
        return inputs.stream().filter(string -> !string.isBlank()).toList();
    }

    public static List<String> splitBy(String input, String regex) {
        return Arrays.stream(input.split(regex)).filter(s -> !s.isBlank()).map(String::trim).toList();
    }
}
