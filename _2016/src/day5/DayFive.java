package day5;

import utils.InputParser;
import utils.StringHelper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class DayFive {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String doorID = new InputParser("_2016/src/day5/input.txt").getLines().getFirst();
        new PasswordHacker().hackPassword(doorID, 1);
        new PasswordHacker().hackPassword(doorID, 2);
    }
}
