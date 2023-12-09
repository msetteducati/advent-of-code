package com.msetteducati.y2023.d7;

import java.util.List;
import java.util.TreeSet;

public class Game {
    private final TreeSet<Hand> hands;

    public Game(List<Hand> hands) {
        this.hands = new TreeSet<>();
        this.hands.addAll(hands);
    }

    public long getTotalWinnings() {
        long totalWinnings = 0;

        int i = 1;
        for (Hand hand : this.hands) {
            totalWinnings += ((long) hand.getBid() * i);
            i++;
        }

        return totalWinnings;
    }

    public static Game fromInput(List<String> input) {
        return new Game(input.stream()
                .map(Hand::fromInput)
                .toList());
    }

    public static Game fromInputPart2(List<String> input) {
        return Game.fromInput(input.stream()
                .map(s -> s.replace('J', 'R'))
                .toList());
    }
}
