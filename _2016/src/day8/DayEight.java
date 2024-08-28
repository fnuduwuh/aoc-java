package day8;

import utils.InputParser;

import java.util.List;

public class DayEight {
    public static void main(String[] args) {
        List<String> lines = new InputParser("_2016/src/day8/input.txt").getLines();
        LCD screen = new LCD(50, 6);
        for (String line : lines) {
            if (line.startsWith("rect")) {
                int[] nums = getRect(line);
                screen.addRectangle(nums[0], nums[1]);
            } else if (line.contains("row")) {
                int[] nums = getRotate(line);
                screen.rotateRow(nums[0], nums[1]);
            } else {
                int[] nums = getRotate(line);
                screen.rotateColumn(nums[0], nums[1]);
            }
            screen.printScreen();
            System.out.println("---------");
        }
        System.out.println("pixels: " + screen.countPixels());
    }

    private static int[] getRect(String line) {
        int[] result = new int[2];
        result[0] = Integer.parseInt(line.substring(line.indexOf(" ") + 1, line.indexOf("x")));
        result[1] = Integer.parseInt(line.split("x")[1]);
        return result;
    }

    private static int[] getRotate(String line) {
        int[] result = new int[2];
        result[0] = Integer.parseInt(line.substring(line.indexOf("=") + 1, line.indexOf(" by")));
        result[1] = Integer.parseInt(line.split("by ")[1]);
        return result;
    }
}
