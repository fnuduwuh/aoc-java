package day9;

import utils.InputParser;

import java.util.List;

public class DayNine {

    public static void main(String[] args) {
        List<String> lines = new InputParser("_2016/src/day9/input.txt").getLines();
        Decompressor decompressor = new Decompressor();
        decompressor.decompressLine(lines.getFirst());
    }
}
