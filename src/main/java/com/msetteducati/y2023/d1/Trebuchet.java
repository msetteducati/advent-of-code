package com.msetteducati.y2023.d1;

import com.msetteducati.util.AdventOfCodeUtil;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Map;

public class Trebuchet {

    public static final Map<String, Integer> NUM_MAP = Map.of(
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9
    );

    @SneakyThrows
    public static void main(String[] args) {
        AdventOfCodeUtil.runFromInputLines(
                "y2023/d1/",
                args[0],
                args[1],
                Trebuchet::part1,
                Trebuchet::part2);
    }

    /**
     * Something is wrong with global snow production, and you've been selected to take a look. The Elves have even given you a map; on it, they've used stars to mark the top fifty locations that are likely to be having problems.
     * <br><br>
     * You've been doing this long enough to know that to restore snow operations, you need to check all fifty stars by December 25th.
     * <br><br>
     * Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!
     * <br><br>
     * You try to ask why they can't just use a weather machine ("not powerful enough") and where they're even sending you ("the sky") and why your map looks mostly blank ("you sure ask a lot of questions") and hang on did you just say the sky ("of course, where do you think snow comes from") when you realize that the Elves are already loading you into a trebuchet ("please hold still, we need to strap you in").
     * <br><br>
     * As they're making the final adjustments, they discover that their calibration document (your puzzle input) has been amended by a very young Elf who was apparently just excited to show off her art skills. Consequently, the Elves are having trouble reading the values on the document.
     * <br><br>
     * The newly-improved calibration document consists of lines of text; each line originally contained a specific calibration value that the Elves now need to recover. On each line, the calibration value can be found by combining the first digit and the last digit (in that order) to form a single two-digit number.
     * <br><br>
     * For example:
     * <pre>
     * 1abc2
     * pqr3stu8vwx
     * a1b2c3d4e5f
     * treb7uchet
     * </pre>
     * In this example, the calibration values of these four lines are 12, 38, 15, and 77. Adding these together produces 142.
     * <br><br>
     * Consider your entire calibration document. What is the sum of all of the calibration values?
     */
    public static int part1(List<String> input) {
        int sum = 0;

        for (String line : input) {
            Character firstDigit = null,
                    lastDigit = null;
            for (int i = 0; i < line.length(); i++) {
                char curChar = line.charAt(i);
                if (Character.isDigit(curChar)) {
                    if (firstDigit == null) {
                        firstDigit = curChar;
                    }
                    lastDigit = curChar;
                }
            }
            sum += Integer.parseInt(String.valueOf(firstDigit) + lastDigit);
        }

        return sum;
    }

    /**
     * Your calculation isn't quite right. It looks like some of the digits are actually spelled out with letters: one, two, three, four, five, six, seven, eight, and nine also count as valid "digits".
     * <br><br>
     * Equipped with this new information, you now need to find the real first and last digit on each line. For example:
     * <pre>
     * two1nine
     * eightwothree
     * abcone2threexyz
     * xtwone3four
     * 4nineeightseven2
     * zoneight234
     * 7pqrstsixteen
     * </pre>
     * In this example, the calibration values are 29, 83, 13, 24, 42, 14, and 76. Adding these together produces 281.
     * @param input
     * @return
     */
    public static int part2(List<String> input) {
        int sum = 0;

        for (String line : input) {
            for (var numMapEntry : NUM_MAP.entrySet()) {
                boolean foundNum = true;
                while (foundNum) {
                    int indexOfNum = line.indexOf(numMapEntry.getKey());
                    if (indexOfNum == -1) {
                        foundNum = false;
                    } else {
                        // Replace the number at indexOfNum + 1 because sometimes start and end letters can match, but never true for second number
                        line = line.substring(0, indexOfNum + 1) + numMapEntry.getValue() + line.substring(indexOfNum + 1);
                    }
                }
            }

            Character firstDigit = null,
                    lastDigit = null;
            for (int i = 0; i < line.length(); i++) {
                char curChar = line.charAt(i);
                if (Character.isDigit(curChar)) {
                    if (firstDigit == null) {
                        firstDigit = curChar;
                    }
                    lastDigit = curChar;
                }
            }
            int toAdd = Integer.parseInt(String.valueOf(firstDigit) + lastDigit);
            sum += toAdd;
        }

        return sum;
    }
}
