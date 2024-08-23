package day7;

import utils.InputParser;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DaySeven {
    public static void main(String[] args) {
        List<String> lines = new InputParser("_2016/src/day7/input.txt").getLines();
        AtomicInteger count = new AtomicInteger();
        NetworkAnalyzer networkAnalyzer = new NetworkAnalyzer();

        lines.forEach(line -> {
            if (networkAnalyzer.checkTLS(line)) {
                count.getAndIncrement();
                System.out.println("line is valid " + count);
            }
        });
    }
}
