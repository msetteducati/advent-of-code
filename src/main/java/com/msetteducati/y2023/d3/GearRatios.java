package com.msetteducati.y2023.d3;

import java.util.*;

public class GearRatios {

    private char[][] schematic;
    private int m;
    private int n;

    private Set<Integer> foundGears;

    /**
     * You and the Elf eventually reach a gondola lift station; he says the gondola lift will take you up to the water source, but this is as far as he can bring you. You go inside.
     * <br><br>
     * It doesn't take long to find the gondolas, but there seems to be a problem: they're not moving.
     * <br><br>
     * "Aaah!"
     * <br><br>
     * You turn around to see a slightly-greasy Elf with a wrench and a look of surprise. "Sorry, I wasn't expecting anyone! The gondola lift isn't working right now; it'll still be a while before I can fix it." You offer to help.
     * <br><br>
     * The engineer explains that an engine part seems to be missing from the engine, but nobody can figure out which one. If you can add up all the part numbers in the engine schematic, it should be easy to work out which part is missing.
     * <br><br>
     * The engine schematic (your puzzle input) consists of a visual representation of the engine. There are lots of numbers and symbols you don't really understand, but apparently any number adjacent to a symbol, even diagonally, is a "part number" and should be included in your sum. (Periods (.) do not count as a symbol.)
     * <br><br>
     * Here is an example engine schematic:
     * <pre>
     * 467..114..
     * ...*......
     * ..35..633.
     * ......#...
     * 617*......
     * .....+.58.
     * ..592.....
     * ......755.
     * ...$.*....
     * .664.598..
     * </pre>
     * In this schematic, two numbers are not part numbers because they are not adjacent to a symbol: 114 (top right) and 58 (middle right). Every other number is adjacent to a symbol and so is a part number; their sum is 4361.
     * <br><br>
     * Of course, the actual engine schematic is much larger. What is the sum of all of the part numbers in the engine schematic?
     * @param fileName
     * @return
     */
    public int part1(List<String> input) {
        processInput(input);

        int partNumberSum = 0;

        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                String curNum = "";
                int startIndex = j;
                while (j < this.schematic[i].length && Character.isDigit(this.schematic[i][j])) {
                    curNum += this.schematic[i][j];
                    j++;
                }

                if (!curNum.equals("")) {
                    boolean foundSymbol = false;
                    for (int k = startIndex; k < j && !foundSymbol; k++) {
                        foundSymbol = foundSymbol || foundAdjacentSymbol(i, k);
                    }
                    if (foundSymbol) {
                        partNumberSum += Integer.parseInt(curNum);
                    }
                }
            }
        }

        return partNumberSum;
    }

    private boolean foundAdjacentSymbol(int i, int j) {
        return isSymbol(i-1, j)
                || isSymbol(i-1, j+1)
                || isSymbol(i, j+1)
                || isSymbol(i+1, j+1)
                || isSymbol(i+1, j)
                || isSymbol(i+1, j-1)
                || isSymbol(i, j-1)
                || isSymbol(i-1, j-1);
    }

    private boolean isSymbol(int i, int j) {
        if (i < 0 || i >= this.m || j < 0 || j >= this.n) {
            return false;
        }

        char input = this.schematic[i][j];
        return !Character.isDigit(input)
                && !Character.isLetter(input)
                && input != '.';
    }

    /**
     * The engineer finds the missing part and installs it in the engine! As the engine springs to life, you jump in the closest gondola, finally ready to ascend to the water source.
     * <br><br>
     * You don't seem to be going very fast, though. Maybe something is still wrong? Fortunately, the gondola has a phone labeled "help", so you pick it up and the engineer answers.
     * <br><br>
     * Before you can explain the situation, she suggests that you look out the window. There stands the engineer, holding a phone in one hand and waving with the other. You're going so slowly that you haven't even left the station. You exit the gondola.
     * <br><br>
     * The missing part wasn't the only issue - one of the gears in the engine is wrong. A gear is any * symbol that is adjacent to exactly two part numbers. Its gear ratio is the result of multiplying those two numbers together.
     * <br><br>
     * This time, you need to find the gear ratio of every gear and add them all up so that the engineer can figure out which gear needs to be replaced.
     * <br><br>
     * Consider the same engine schematic again:
     * <pre>
     * 467..114..
     * ...*......
     * ..35..633.
     * ......#...
     * 617*......
     * .....+.58.
     * ..592.....
     * ......755.
     * ...$.*....
     * .664.598..
     * </pre>
     * In this schematic, there are two gears. The first is in the top left; it has part numbers 467 and 35, so its gear ratio is 16345. The second gear is in the lower right; its gear ratio is 451490. (The * adjacent to 617 is not a gear because it is only adjacent to one part number.) Adding up all of the gear ratios produces 467835.
     * <br><br>
     * What is the sum of all of the gear ratios in your engine schematic?
     * @param input
     * @return
     */
    public int part2(List<String> input) {
        processInput(input);

        // Map of * char index hash -> part number
        Map<Integer, List<Integer>> potentialGearMap = new HashMap<>();

        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                String curNumStr = "";
                int startIndex = j;
                while (j < this.schematic[i].length && Character.isDigit(this.schematic[i][j])) {
                    curNumStr += this.schematic[i][j];
                    j++;
                }

                if (!curNumStr.equals("")) {
                    this.foundGears = new HashSet<>();
                    int resetJ = j;
                    for (j = startIndex; j < resetJ; j++) {
                        findGearHash(i-1, j);
                        findGearHash(i-1, j+1);
                        findGearHash(i, j+1);
                        findGearHash(i+1, j+1);
                        findGearHash(i+1, j);
                        findGearHash(i+1, j-1);
                        findGearHash(i, j-1);
                        findGearHash(i-1, j-1);
                    }
                    j = resetJ;

                    int curPartNum = Integer.parseInt(curNumStr);
                    this.foundGears.forEach(gearHash -> {
                        if (!potentialGearMap.containsKey(gearHash)) {
                            potentialGearMap.put(gearHash, new ArrayList<>());
                        }
                        potentialGearMap.get(gearHash).add(curPartNum);
                    });
                }
            }
        }

        return potentialGearMap.values().stream()
                .filter(partNums -> partNums.size() == 2)
                .map(partNums -> partNums.get(0) * partNums.get(1))
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void findGearHash(int i, int j) {
        if (i < 0 || i >= this.m || j < 0 || j >= this.n) {
            return;
        }

        if (this.schematic[i][j] == '*') {
            this.foundGears.add(hash(i, j));
        }
    }

    private int hash(int i, int j) {
        return (i * this.n) + j;
    }

    private void processInput(List<String> input) {
        // Convert to char array
        // Assumes that input.size() > 0 and that all lines are equal length
        this.m = input.size();
        this.n = input.get(0).length();
        this.schematic = new char[this.m][this.n];
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                this.schematic[i][j] = input.get(i).charAt(j);
            }
        }
    }
}
