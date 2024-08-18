package day5;

import utils.StringHelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class PasswordHacker {
    private String[] password = new String[8];
    private int trackingIndex = 0;

    public void hackPassword(String doorID, int part) throws NoSuchAlgorithmException {
        int addTo = 0;
        System.out.println("Decrypting password for part two for door with ID: " + doorID);
        while (true) {
            String door = doorID + addTo;
            byte[] digest = MessageDigest.getInstance("MD5").digest(door.getBytes());
            String hexString = StringHelper.toHexString(digest);
            if (hexString.startsWith("00000")) {
                processHash(hexString, part);

                if (trackingIndex == 8) {
                    System.out.println("Password found: " + getPassword());
                    return;
                }
            }
            addTo += 1;
        }
    }

    private String getPassword() {
        StringBuilder password = new StringBuilder();
        Arrays.stream(this.password).forEach(password::append);
        return password.toString();
    }

    private void processHash(String hexString, int part) {
        if (part == 1) {
            System.out.println("Password digit found! Processing: " + hexString);
            this.password[trackingIndex] = String.valueOf(hexString.charAt(5));
            trackingIndex++;
        } else {
            System.out.println("Possible password digit! Processing: " + hexString);
            int passwordIndex = StringHelper.isNumeric(String.valueOf(hexString.charAt(5))) ? Integer.parseInt(String.valueOf(hexString.charAt(5))) : 9;
            if (passwordIndex < 8 && this.password[passwordIndex] == null) {
                this.password[passwordIndex] = String.valueOf(hexString.charAt(6));
                trackingIndex++;
                System.out.println("Password digit found! \nBuilding password: " + Arrays.toString(this.password));
            }
        }
    }

}
