package org.aoc.helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class InputHelper {

    public static List<String> getInputAsListOfLines() {
        try {
            return Files.readAllLines(Path.of("input.txt"));
        } catch (IOException e) {
            System.out.println("No input file found in working directory. Assumption is you're running unit tests");
            return null;
        }
    }
}
