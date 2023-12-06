package com.msetteducati.y2023.d5;

import com.msetteducati.util.FileUtil;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeedFertilizerTest {

    private SeedFertilizer seedFertilizer;

    @BeforeEach
    void setUp() {
        this.seedFertilizer = new SeedFertilizer();
    }

    @Test
    void part1_sample() {
        List<String> input = FileUtil.getLines("y2023/d5/sample-input.txt");
        var result = seedFertilizer.part1(input);
        assertEquals((long) 35, result);
    }

    @Test
    void part1_full() {
        List<String> input = FileUtil.getLines("y2023/d5/full-input.txt");
        var result = seedFertilizer.part1(input);
        System.out.println(result);
        assertEquals(525792406, result);
    }

    @Test
    void part2_sample() {
        List<String> input = FileUtil.getLines("y2023/d5/sample-input.txt");
        var result = seedFertilizer.part2(input);
        assertEquals((long) 46, result);
    }

    @Test
    @Disabled("too slow")
    void part2_full() {
        List<String> input = FileUtil.getLines("y2023/d5/full-input.txt");
        var result = seedFertilizer.part2(input);
        System.out.println(result);
        assertEquals(79004094, result);
    }
}