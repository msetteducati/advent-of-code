package com.msetteducati.y2023.d4;

import lombok.*;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@Builder
public class Card {
    private int id;
    private Set<Integer> winningNumbers;
    private Set<Integer> actualNumbers;

    public int computeValue() {
        int matches = this.getNumMatches();
        return matches == 0
                ? 0
                : (int) Math.pow(2, matches - 1);
    }

    public int getNumMatches() {
        int matches = 0;
        for (Integer actualNum : this.actualNumbers) {
            if (this.winningNumbers.contains(actualNum)) {
                matches++;
            }
        }
        return matches;
    }

    public static Card fromString(String input) {
        String[] cardSplit = input.split(":");
        String id = cardSplit[0].replace("Card", "").trim();

        String[] numberSplit = cardSplit[1].split("\\|");
        Set<Integer> winningNumbers = numbersFromString(numberSplit[0]);
        Set<Integer> actualNumbers = numbersFromString(numberSplit[1]);

        return Card.builder()
                .id(Integer.parseInt(id))
                .winningNumbers(winningNumbers)
                .actualNumbers(actualNumbers)
                .build();
    }

    private static Set<Integer> numbersFromString(String input) {
        return Arrays.stream(input.trim().split(" "))
                .filter(s -> !s.isBlank())
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
