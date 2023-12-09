package com.msetteducati.y2023.d8;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Direction {
    LEFT('L'),
    RIGHT('R');

    private final Character label;

    public WastelandTreeNode traverse(WastelandTreeNode input) {
        return switch (this) {
            case LEFT -> input.getLeft();
            case RIGHT -> input.getRight();
        };
    }

    public static Direction fromChar(char input) {
        return switch(input) {
            case 'L' -> LEFT;
            case 'R' -> RIGHT;
            default -> throw new RuntimeException("unexpected direction input");
        };
    }
}
