package day1;

import utils.InputParser;

import java.util.List;

public class DayOne {
    public static void main(String[] args) {
        List<String> inputs = new InputParser("_2016/src/day1/input.txt").getLinesSplitByComma();
        Mover mover = new Mover();
        inputs.forEach(input -> {
            int steps = Integer.parseInt(input.substring(1));
            mover.changeDirection(input.split("")[0]);
            mover.move(steps);

        });
        System.out.println("Distance travelled: " + Math.abs(-mover.getX() + Math.abs(-mover.getY())));
        System.out.println("Distance travelled to first twice visited: " + mover.getDistanceForFirstPointVisitedTwice());
    }

}