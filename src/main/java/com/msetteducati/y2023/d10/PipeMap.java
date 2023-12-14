package com.msetteducati.y2023.d10;

import com.google.common.annotations.VisibleForTesting;
import com.msetteducati.util.Pair;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.*;

public class PipeMap {

    @Getter(value = AccessLevel.PACKAGE, onMethod_ = {@VisibleForTesting})
    private final int m;

    @Getter(value = AccessLevel.PACKAGE, onMethod_ = {@VisibleForTesting})
    private final int n;

    @Getter(value = AccessLevel.PACKAGE, onMethod_ = {@VisibleForTesting})
    private final Map<Tile, List<Tile>> map;

    @Getter(value = AccessLevel.PACKAGE, onMethod_ = {@VisibleForTesting})
    private Tile startTile;

    private PipeMap(List<String> input) {
        this.m = input.size();
        this.n = input.get(0).length();
        this.map = new HashMap<>();
        this.startTile = null;

        // Process input
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                PipeType pipeType = PipeType.fromChar(input.get(i).charAt(j));
                Tile curTile = new Tile(i, j);
                List<Tile> connectedTiles = pipeType.getConnectionFunctions().stream()
                        .map(fn -> fn.apply(curTile))
                        .filter(this::isValidTile)
                        .toList();

                if (connectedTiles.size() >= 2) {
                    this.map.put(curTile, connectedTiles);
                }

                if (PipeType.START.equals(pipeType)) {
                    this.startTile = curTile;
                }
            }
        }


        if (this.startTile == null) {
            throw new RuntimeException("did not find start");
        }

        // Set start connections properly
        this.map.put(this.startTile, this.map.get(this.startTile).stream()
                .filter(connectedTile -> this.map.containsKey(connectedTile)
                        && this.map.get(connectedTile).contains(startTile))
                .toList());
    }

    public int getFurtherPositionDistanceLinear() {
        Tile prevTile = startTile,
                curTile = this.map.get(startTile).get(0);

        int distance = 1;

        while (!curTile.equals(startTile)) {
            Tile nextTile = getNextTile(curTile, prevTile);
            prevTile = curTile;
            curTile = nextTile;
            distance++;
        }

        return (distance + 1) / 2;
    }

    private Tile getNextTile(Tile curTile, Tile prevTile) {
        return this.map.get(curTile).stream()
                .filter(tile -> !tile.equals(prevTile))
                .findFirst()
                .orElseThrow();
    }

    public int getFurtherPositionDistance() {
        Set<Tile> visited = new HashSet<>();
        int maxDistance = 0;

        // For BFS - Pair of (tile, distance)
        Queue<Pair<Tile, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(this.startTile, 0));

        while (!queue.isEmpty()) {
            var curPair = queue.remove();
            var curTile = curPair.getLeft();

            // Mark visited and update max distance if appropriate
            visited.add(curTile);
            maxDistance = Math.max(maxDistance, curPair.getRight());

            // BFS to connected tiles
            for (Tile connectedTile : this.map.get(curTile)) {
                if (!visited.contains(connectedTile)) {
                    queue.add(new Pair<>(connectedTile, curPair.getRight() + 1));
                }
            }
        }

        return maxDistance;
    }

    private boolean isValidTile(Tile tile) {
        return tile.getRow() >= 0 && tile.getRow() < this.m
                && tile.getCol() >= 0 && tile.getCol() < this.n;
    }

    public static PipeMap fromInput(List<String> input) {
        return new PipeMap(input);
    }
}
