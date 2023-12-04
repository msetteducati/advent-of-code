package com.msetteducati.y2023.d3;

import com.msetteducati.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GearRatiosTest {

    private GearRatios gearRatios;

    @BeforeEach
    void setUp() {
        this.gearRatios = new GearRatios();
    }

    @Test
    void part1_sample() {
        List<String> input = FileUtil.getLines("y2023/d3/sample-input.txt");
        var result = gearRatios.part1(input);
        assertEquals(4361, result);
    }

    @Test
    void part1_full() {
        List<String> input = FileUtil.getLines("y2023/d3/full-input.txt");
        var result = gearRatios.part1(input);
        assertEquals(557705, result);
    }

    @Test
    void part2_sample() {
        List<String> input = FileUtil.getLines("y2023/d3/sample-input.txt");
        var result = gearRatios.part2(input);
        assertEquals(467835, result);
    }

    @Test
    void part2_full() {
        List<String> input = FileUtil.getLines("y2023/d3/full-input.txt");
        var result = gearRatios.part2(input);
        assertEquals(84266818, result);
    }
}