package day8;

import utils.InputParser;

import java.util.List;

public class DayEight {
    public static void main (String[] args) {
        List<String> lines = new InputParser("_2016/src/day8/input.txt").getLines();
        TinyScreen lcd = new TinyScreen(50, 6);
        for (String line : lines) {
            if (line.startsWith("rect")) {
                int[] nums = getRect(line);
                lcd.addRectangle(nums[0], nums[1]);
            } else if (line.contains("row")) {
                int[] nums = getRotate(line);
                lcd.rotateRow(nums[0], nums[1]);
            } else {
                int[] nums = getRotate(line);
                lcd.rotateColumn(nums[0], nums[1]);
            }
        }
        System.out.println("Number of pixels turned on: " + lcd.getNumberOfPixelsTurnedOn());
    }

    private static int[] getRect(String line) {
        int[] result = new int[2];
        result[0] = Integer.parseInt(line.split(" ")[1].substring(0, 1));
        result[1] = Integer.parseInt(line.split("x")[1]);
        return result;
    }

    private static int[] getRotate(String line) {
        int[] result = new int[2];
        result[0] = Integer.parseInt(line.split("=")[1].substring(0, line.indexOf(" by")-line.indexOf("=")).trim());
        result[1] = Integer.parseInt(line.split("by ")[1]);
        return result;
    }
}
