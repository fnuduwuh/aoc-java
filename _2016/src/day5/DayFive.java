package day5;

import utils.InputParser;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DayFive {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String doorID = new InputParser("_2016/src/day5/input.txt").getLines().getFirst();
        MessageDigest md = MessageDigest.getInstance("MD5");
        int addTo = 0;
        System.out.println("Decrypting password for door with ID: " + doorID);
        StringBuilder password = new StringBuilder();
        while (true) {
            String door = doorID + addTo;
            byte[] digest = md.digest(door.getBytes());
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
