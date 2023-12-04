package com.msetteducati.y2023.d1;

import com.msetteducati.util.FileUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrebuchetTest {

    @Test
    void part1() {
        List<String> input = FileUtil.getLines("y2023/d1/full-input.txt");
        var result = Trebuchet.part1(input);
        assertEquals(53921, result);
    }

    @Test
    void part2() {
        List<String> input = FileUtil.getLines("y2023/d1/full-input.txt");
        var result = Trebuchet.part2(input);
        assertEquals(54676, result);
    }
}