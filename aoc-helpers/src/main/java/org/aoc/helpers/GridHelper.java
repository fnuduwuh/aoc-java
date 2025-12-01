package org.aoc.helpers;

public class GridHelper {

    public static boolean isAdjacentTo(int x, int y, int x2, int y2) {
        if (x == x2 && y == y2) {
            return false;
        } else return Math.abs(x - x2) <= 1 && Math.abs(y - y2) <= 1;
    }
}
