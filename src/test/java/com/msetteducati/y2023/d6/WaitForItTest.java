package com.msetteducati.y2023.d6;

import com.msetteducati.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WaitForItTest {

    private WaitForIt waitForIt;

    @BeforeEach
    void setUp() {
        waitForIt = new WaitForIt();
    }

    @Test
    void part1_sample() {
        List<String> input = FileUtil.getLines("y2023/d6/sample-input.txt");
        var result = waitForIt.part1(input);
        assertEquals(288, result);
    }

    @Test
    void part1_full() {
        List<String> input = FileUtil.getLines("y2023/d6/full-input.txt");
        var result = waitForIt.part1(input);
        System.out.println(result);
        assertEquals(1159152, result);
    }

    @Test
    void part2_sample() {
        List<String> input = FileUtil.getLines("y2023/d6/sample-input.txt");
        var result = waitForIt.part2(input);
        assertEquals(71503, result);
    }

    @Test
    void part2_full() {
        List<String> input = FileUtil.getLines("y2023/d6/full-input.txt");
        var result = waitForIt.part2(input);
        System.out.println(result);
        assertEquals(41513103, result);
    }
}