package day9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decompressor {
private int length;
    public String decompressLine(String line) {
        length = 0;
        StringBuilder newline = new StringBuilder(line);
        Pattern pattern = Pattern.compile("\\([0-9]*x[0-9]*\\)");
        while (true) {
            Matcher matcher = pattern.matcher(newline);
            if (matcher.find()) {
                int[] nums = processMarker(matcher.group(0));
                length += nums[0] * nums[1];
                System.out.println(newline.indexOf(matcher.group(0)) + " : " + matcher.group(0).length() + nums[0]);
                newline.delete(newline.indexOf(matcher.group(0)), newline.indexOf(matcher.group(0)) + matcher.group(0).length() + nums[0]);
                System.out.println(newline);
            } else {
                break;
            }
        }
        System.out.println("newlinefinal: " + newline);
        System.out.println(length + newline.length());
        return line;
    }

    public int[] processMarker(String marker) {
        int amountOfChars = Integer.parseInt(marker.substring(1, marker.indexOf("x")));
        int repeat = Integer.parseInt(marker.substring(marker.indexOf("x") + 1, marker.indexOf(")")));
        System.out.println(marker);
        return new int[]{amountOfChars, repeat};
    }
}

