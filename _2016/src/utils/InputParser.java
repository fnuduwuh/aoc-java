package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

    public List<String> getLinesSplitByComma() {
        List<String> splitted = new ArrayList<>();
        lines.forEach(line -> splitted.addAll(List.of(line.split(","))));
        return splitted.stream().map(String::trim).toList();
    }
}
