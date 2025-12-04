package org.aoc25;

import org.aoc25.days.Day1;
import org.aoc25.days.Day2;
import org.aoc25.days.Day4;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to AOC 2025 solutions");
        System.out.println("Please make sure to enter the correct input in the text file under resources");
        System.out.println("Please enter the day for which you'd like to see the solution:");
        Scanner scanner = new Scanner(System.in);

        switch (scanner.nextInt()) {
            case 1 -> new Day1().printSolutions();
            case 2 -> new Day2().printSolutions();
            case 4 -> new Day4().printSolutions();
        }
    }
}
