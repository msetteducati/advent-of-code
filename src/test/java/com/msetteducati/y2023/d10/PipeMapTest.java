package com.msetteducati.y2023.d10;

import com.msetteducati.util.FileUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PipeMapTest {

    @Test
    void fromInput() {
        List<String> input = FileUtil.getLines("y2023/d10/sample-input.txt");
        PipeMap pipeMap = PipeMap.fromInput(input);

        assertEquals(6, pipeMap.getM());
        assertEquals(5, pipeMap.getN());
        assertEquals(2, pipeMap.getStartTile().getRow());
        assertEquals(0, pipeMap.getStartTile().getCol());
        assertEquals(2, pipeMap.getMap().get(new Tile(2, 0)).size());
        assertEquals(2, pipeMap.getMap().get(new Tile(2, 3)).size());
        assertFalse(pipeMap.getMap().containsKey(new Tile(0, 0)));
    }
}