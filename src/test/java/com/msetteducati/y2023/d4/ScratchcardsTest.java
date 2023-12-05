package com.msetteducati.y2023.d4;

import com.msetteducati.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScratchcardsTest {

    private Scratchcards scratchcards;

    @BeforeEach
    void setUp() {
        this.scratchcards = new Scratchcards();
    }

    @Test
    void part1_sample() {
        List<String> input = FileUtil.getLines("y2023/d4/sample-input.txt");
        var result = scratchcards.part1(input);
        assertEquals(13, result);
    }

    @Test
    void part1_full() {
        List<String> input = FileUtil.getLines("y2023/d4/full-input.txt");
        var result = scratchcards.part1(input);
        System.out.println(result);
        assertEquals(25651, result);
    }

    @Test
    void part2_sample() {
        List<String> input = FileUtil.getLines("y2023/d4/sample-input.txt");
        var result = scratchcards.part2(input);
        assertEquals(30, result);
    }

    @Test
    void part2_full() {
        List<String> input = FileUtil.getLines("y2023/d4/full-input.txt");
        var result = scratchcards.part2(input);
        System.out.println(result);
        assertEquals(19499881, result);
    }
}