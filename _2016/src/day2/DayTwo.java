package day2;

import utils.InputParser;

import java.util.List;

public class DayTwo {

    public static void main(String[] args) {
        List<String> inputs = new InputParser("_2016/src/day2/input.txt").getLinesSplitByComma();
        Keypad keypad = new Keypad();
        inputs.forEach(input -> keypad.move(input.split("")));
        System.out.println("Keypad code: " + keypad.getKeys());
    }
}
