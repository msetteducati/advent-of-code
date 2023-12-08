package com.msetteducati.y2023.d6;

import com.msetteducati.util.FileUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrandPrixTest {

    @Test
    void fromInputPart1() {
        List<String> input = FileUtil.getLines("y2023/d6/sample-input.txt");
        GrandPrix grandPrix = GrandPrix.fromInputPart1(input);

        assertEquals(3, grandPrix.getRaces().size());
        assertEquals(7, grandPrix.getRaces().get(0).getTime());
        assertEquals(9, grandPrix.getRaces().get(0).getRecordDistance());
        assertEquals(30, grandPrix.getRaces().get(2).getTime());
        assertEquals(200, grandPrix.getRaces().get(2).getRecordDistance());
    }

    @Test
    void fromInputPart2() {
        List<String> input = FileUtil.getLines("y2023/d6/sample-input.txt");
        GrandPrix grandPrix = GrandPrix.fromInputPart2(input);

        assertEquals(1, grandPrix.getRaces().size());
        assertEquals(71530, grandPrix.getRaces().get(0).getTime());
        assertEquals(940200, grandPrix.getRaces().get(0).getRecordDistance());
    }
}