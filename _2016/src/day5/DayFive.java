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
        partOne(doorID);
        partTwo(doorID);
    }

    private static void partTwo(String doorID) throws NoSuchAlgorithmException {
        int addTo = 0;
        System.out.println("Decrypting password for part two for door with ID: " + doorID);
        String[] password2 = new String[8];
        int passwordLength = 0;
        while (true) {
            String door = doorID + addTo;
            byte[] digest = MessageDigest.getInstance("MD5").digest(door.getBytes());
            String hexString = toHex(digest);
//            System.out.println("Hashes processed: " + addTo);
            if (hexString.startsWith("00000")) {
                int passwordIndex = StringHelper.isNumeric(String.valueOf(hexString.charAt(5))) ? Integer.parseInt(String.valueOf(hexString.charAt(5))) : 9;
                System.out.println("Possible password digit! Processing: " + hexString);
                if (passwordIndex < 8 && password2[passwordIndex] == null) {
                    passwordLength++;
                    password2[passwordIndex] = String.valueOf(hexString.charAt(6));
                    System.out.println("Password digit found! \n Building password: " + Arrays.toString(password2));
                }
                if (passwordLength == 8) {
                    System.out.println("Password found: " + Arrays.toString(password2));
                    return;
                }
            }
            addTo += 1;
        }
    }

    private static void partOne(String doorID) throws NoSuchAlgorithmException {
        int addTo = 0;
        System.out.println("Decrypting password for door with ID: " + doorID);
        StringBuilder password = new StringBuilder();
        while (true) {
            String door = doorID + addTo;
            byte[] digest = MessageDigest.getInstance("MD5").digest(door.getBytes());
            String hexString = toHex(digest);
//            System.out.println("Hashes processed: " + addTo);
            if (hexString.startsWith("00000")) {
                System.out.println("Password digit found: " + hexString.charAt(5));
                password.append(hexString.charAt(5));
                if (password.length() == 8) {
                    System.out.println("Password found: " + password);
                    return;
                }
            }
            addTo += 1;
        }
    }

    public static String toHex(byte[] bytes) {
        BigInteger bi = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "X", bi);
    }
}
