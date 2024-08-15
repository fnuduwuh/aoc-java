package day3;

import java.util.ArrayList;
import java.util.List;

import utils.InputParser;

public class DayThree {
public static void main(String[] args) {
    List<String> inputs = new InputParser("_2016/src/day3/input.txt").getLines();
    TriangleHandler triangleHandler = new TriangleHandler();
    List<String> possibleTriangles = new ArrayList<>();
    List<List<String>> possibleTriangles2 = new ArrayList<>();
    List<List<String>> trianglesPartTwo = new ArrayList<>();
    inputs.forEach(input -> {
        List<String> triangle = InputParser.splitBy(input, "\\s+");
        trianglesPartTwo.add(triangle);
        if (triangleHandler.calculateTrianglePossible(triangle)) {
            possibleTriangles.add(input);
        }
    });
    System.out.println("Amount of possible triangles: " + possibleTriangles.size());
    triangleHandler.getVerticalTriangles(trianglesPartTwo).forEach(triangle -> {
        if (triangleHandler.calculateTrianglePossible(triangle)) {
            possibleTriangles2.add(triangle);
        }
    });
    System.out.println("Amount of possible triangles for part two: " + possibleTriangles2.size());
}
}
