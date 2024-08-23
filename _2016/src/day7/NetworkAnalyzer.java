package day7;

public class NetworkAnalyzer {

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
