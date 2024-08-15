package day3;

import java.util.ArrayList;
import java.util.List;

import utils.InputParser;

public class DayThree {
public static void main(String[] args) {
    List<String> inputs = new InputParser("_2016/src/day3/input.txt").getLines();
    TriangleHandler triangleHandler = new TriangleHandler();
    List<String> possibleTriangles = new ArrayList<>();
    inputs.forEach(input -> {
        List<String> triangle = InputParser.splitBy(input, "\\s+");
        if (triangleHandler.calculateTrianglePossible(triangle)) {
            possibleTriangles.add(input);
        }
    });
    System.out.println("Amount of possible triangles: " + possibleTriangles.size());
}
}
