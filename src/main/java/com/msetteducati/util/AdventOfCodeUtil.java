package com.msetteducati.util;

import lombok.experimental.UtilityClass;

import java.util.function.Function;

@UtilityClass
public class AdventOfCodeUtil {
    public void takeInputAndRunPart(String fileName,
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
}
