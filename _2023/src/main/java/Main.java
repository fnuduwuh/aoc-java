import org.aoc23.days.*;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        System.out.println("Welcome to AOC 2023 solutions");
        System.out.println("Please make sure to enter the correct input in the text file under resources");
        System.out.println("Please enter the day for which you'd like to see the solution:");
        Scanner scanner = new Scanner(System.in);

        switch (scanner.nextInt()) {
            case 1 -> new Day1().printSolutions();
            case 2 -> new Day2().printSolutions();
            case 3 -> new Day3().printSolutions();
            case 4 -> new Day4().printSolutions();
            case 5 -> new Day5().printSolutions();
            case 6 -> new Day6().printSolutions();
            case 7 -> new Day7().printSolutions();
            default -> System.out.println("This day has no solutions yet");
        }
    }
}
