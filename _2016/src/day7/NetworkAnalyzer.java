package day7;

import java.util.ArrayList;
import java.util.List;

public class NetworkAnalyzer {

    public boolean checkSSL(String IP) {
        boolean hypernet = false;
        List<String> aba = new ArrayList<>();
        List<String> bab = new ArrayList<>();

        String[] split = IP.split("");
        for (int i = 0; i < split.length - 2; i++) {
            if (split[i].equals("[")) {
                hypernet = true;
            } else if (split[i].equals("]")) {
                hypernet = false;
            } else if (split[i].equals(split[i + 2])) {
                if (hypernet) {
                    String mirrored = split[i + 1] + split[i] + split[i + 1];
                    bab.add(mirrored);
                    if (aba.contains(mirrored)) return true;
                } else {
                    String hit = split[i] + split[i + 1] + split[i + 2];
                    aba.add(hit);
                    if (bab.contains(hit)) return true;
                }
            }
        }
        return false;
    }

    public boolean checkTLS(String IP) {
        boolean hypernet = false;
        boolean abba = false;

        String[] split = IP.split("");
        for (int i = 0; i < split.length - 3; i++) {
            if (split[i].equals("[")) {
                hypernet = true;
            } else if (split[i].equals("]")) {
                hypernet = false;
            } else if (split[i].equals(split[i + 3]) && split[i + 1].equals(split[i + 2])) {
                if (!split[i].equals(split[i + 1])) {
                    if (hypernet) {
                        abba = false;
                        break;
                    } else {
                        abba = true;
                    }
                }
            }
        }
        return abba;
    }
}
