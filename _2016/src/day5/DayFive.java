package day5;

import utils.InputParser;

import java.security.NoSuchAlgorithmException;

public class DayFive {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String doorID = new InputParser("_2016/src/day5/input.txt").getLines().getFirst();
        new PasswordHacker().hackPassword(doorID, 1);
        new PasswordHacker().hackPassword(doorID, 2);
    }
}
