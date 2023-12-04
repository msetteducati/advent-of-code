package com.msetteducati.util;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.function.Function;

@UtilityClass
public class AdventOfCodeUtil {
    public void runFromFileName(String fileName,
                                String part,
                                Function<String, Integer> part1Function,
                                Function<String, Integer> part2Function) {
        int result = switch (part) {
            case "p1" -> part1Function.apply(fileName);
            case "p2" -> part2Function.apply(fileName);
            default -> throw new IllegalStateException("Unexpected value: " + part);
        };
        System.out.println(result);
    }

    public void runFromInputLines(String fileNamePrefix,
                                  String fileName,
                                  String part,
                                  Function<List<String>, Integer> part1Function,
                                  Function<List<String>, Integer> part2Function) {
        List<String> input = FileUtil.getLines(fileNamePrefix + fileName);
        int result = switch (part) {
            case "p1" -> part1Function.apply(input);
            case "p2" -> part2Function.apply(input);
            default -> throw new IllegalStateException("Unexpected value: " + part);
        };
        System.out.println(result);
    }
}
