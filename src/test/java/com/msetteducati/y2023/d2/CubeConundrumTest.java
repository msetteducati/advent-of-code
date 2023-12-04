package com.msetteducati.y2023.d2;

import com.msetteducati.util.FileUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CubeConundrumTest {

    @Test
    void part1() {
        List<String> input = FileUtil.getLines("y2023/d2/full-input.txt");
        var result = CubeConundrum.part1(input);
        assertEquals(2416, result);
    }

    @Test
    void part2() {
        List<String> input = FileUtil.getLines("y2023/d2/full-input.txt");
        var result = CubeConundrum.part2(input);
        assertEquals(63307, result);
    }
}