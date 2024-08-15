package day2;

import utils.InputParser;

import java.util.List;

public class DayTwo {

    public static void main(String[] args) {
        List<String> inputs = new InputParser("_2016/src/day2/input.txt").getLinesSplitByComma();
        Keypad keypad_pt1 = new Keypad(1);
        inputs.forEach(input -> keypad_pt1.move(input.split("")));
        System.out.println("Keypad code: " + keypad_pt1.getKeys());
        Keypad keypad_pt2 = new Keypad(2);
        inputs.forEach(input -> keypad_pt2.move(input.split("")));
        System.out.println("Keypad code: " + keypad_pt2.getKeys());
    }
}
