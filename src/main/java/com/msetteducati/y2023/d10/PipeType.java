package com.msetteducati.y2023.d10;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@AllArgsConstructor
public enum PipeType {
    VERTICAL('|', List.of(
            input -> new Tile(input.getRow()-1, input.getCol()),
            input -> new Tile(input.getRow()+1, input.getCol())
    )),
    HORIZONTAL('-', List.of(
            input -> new Tile(input.getRow(), input.getCol()-1),
            input -> new Tile(input.getRow(), input.getCol()+1)
    )),
    NORTH_TO_EAST('L', List.of(
            input -> new Tile(input.getRow()-1, input.getCol()),
            input -> new Tile(input.getRow(),input.getCol()+1)
    )),
    NORTH_TO_WEST('J', List.of(
            input -> new Tile(input.getRow()-1, input.getCol()),
            input -> new Tile(input.getRow(), input.getCol()-1)
    )),
    SOUTH_TO_WEST('7', List.of(
            input -> new Tile(input.getRow()+1, input.getCol()),
            input -> new Tile(input.getRow(), input.getCol()-1)
    )),
    SOUTH_TO_EAST('F', List.of(
            input -> new Tile(input.getRow()+1, input.getCol()),
            input -> new Tile(input.getRow(), input.getCol()+1)
    )),
    START('S', List.of( // Naively assume that it can connect in all four directions
            input -> new Tile(input.getRow()-1, input.getCol()),
            input -> new Tile(input.getRow()+1, input.getCol()),
            input -> new Tile(input.getRow(), input.getCol()-1),
            input -> new Tile(input.getRow(), input.getCol()+1)
    )),
    GROUND('.', List.of());

    private final char key;

    @Getter
    private final List<Function<Tile, Tile>> connectionFunctions;

    private static final Map<Character, PipeType> map;

    static {
        map = new HashMap<>();
        for (PipeType pipeType : PipeType.values()) {
            map.put(pipeType.key, pipeType);
        }
    }

    public static PipeType fromChar(char input) {
        return map.get(input);
    }
}
