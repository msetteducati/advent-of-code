package com.msetteducati.y2023.d10;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Tile {
    private final int row;
    private final int col;

    /**
     * Based on constraints of this puzzle, this hash method will guarantee uniqueness.
     * @return
     */
    @Override
    public int hashCode() {
        return (this.row * 10000000) + this.col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Tile tile = (Tile) o;
        return row == tile.row && col == tile.col;
    }
}
