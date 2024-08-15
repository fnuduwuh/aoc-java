package day3;

import java.util.Arrays;
import java.util.List;

public class TriangleHandler {

    public boolean calculateTrianglePossible(List<String> triangle) {
        int[] sides = {Integer.parseInt(triangle.getFirst()), Integer.parseInt(triangle.get(1)), Integer.parseInt(triangle.getLast())};
        sides = Arrays.stream(sides).sorted().toArray();
        return sides[0] + sides[1] > sides[2];
    }

}
