package day6;

import utils.InputParser;

import java.util.List;

public class DaySix {
    public static void main(String[] args) {
        List<String> lines = new InputParser("_2016/src/day6/input.txt").getLines();
        CharacterFinder characterFinder = new CharacterFinder(lines);
        characterFinder.findMostAndLeastCommonCharacters();
        characterFinder.printErrorCorrectedMessage();
    }


}
