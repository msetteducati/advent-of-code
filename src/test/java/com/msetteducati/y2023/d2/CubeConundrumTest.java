package com.msetteducati.y2023.d2;

import com.msetteducati.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CubeConundrumTest {

    private CubeConundrum cubeConundrum;

    @BeforeEach
    void setUp() {
        this.cubeConundrum = new CubeConundrum();
    }

    @Test
    void part1() {
        List<String> input = FileUtil.getLines("y2023/d2/full-input.txt");
        var result = cubeConundrum.part1(input);
        assertEquals(2416, result);
    }

    @Test
    void part2() {
        List<String> input = FileUtil.getLines("y2023/d2/full-input.txt");
        var result = cubeConundrum.part2(input);
        assertEquals(63307, result);
    }
}