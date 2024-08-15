package day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleHandler {

    List<List<String>> trianglesCol1 = new ArrayList<>();
    List<List<String>> trianglesCol2 = new ArrayList<>();
    List<List<String>> trianglesCol3 = new ArrayList<>();

    public boolean calculateTrianglePossible(List<String> triangle) {
        int[] sides = { Integer.parseInt(triangle.getFirst()), Integer.parseInt(triangle.get(1)), Integer.parseInt(triangle.getLast()) };
        sides = Arrays.stream(sides).sorted().toArray();
        return sides[0] + sides[1] > sides[2];
    }

    public List<List<String>> getVerticalTriangles(List<List<String>> inputs) {
        for (int i = 0; i < inputs.size(); i++) {
            if (i % 3 == 0) {
                trianglesCol1.add(new ArrayList<>());
                trianglesCol2.add(new ArrayList<>());
                trianglesCol3.add(new ArrayList<>());
            }
            int index = Math.floorDiv(i, 3);
            trianglesCol1.get(index).add(inputs.get(i).get(0));
            trianglesCol2.get(index).add(inputs.get(i).get(1));
            trianglesCol3.get(index).add(inputs.get(i).get(2));
        }
        trianglesCol1.addAll(trianglesCol2);
        trianglesCol1.addAll(trianglesCol3);
        return trianglesCol1;
    }

}
