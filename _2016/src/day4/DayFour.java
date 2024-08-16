package day4;

import utils.InputParser;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DayFour {

    public static void main(String[] args) {
        List<String> input = new InputParser("_2016/src/day4/input.txt").getLines();
        AtomicInteger sum = new AtomicInteger();
        input.forEach(line -> {
            Room room = new Room(line);
            if (room.isValid()) {
                sum.addAndGet(room.getId());
            }
            if(room.getDecryptedName().contains("north")) {
                System.out.println(room.getDecryptedName() + "-> ID: " + room.getId());
            }
        });
        System.out.println("Sum of id's: " + sum);
    }
}
