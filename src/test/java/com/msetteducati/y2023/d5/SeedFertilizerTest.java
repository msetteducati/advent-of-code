package com.msetteducati.y2023.d5;

import com.msetteducati.PuzzleSolutionTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static com.msetteducati.model.FileType.FULL;
import static com.msetteducati.model.FileType.SAMPLE;
import static com.msetteducati.model.Part.PART1;
import static com.msetteducati.model.Part.PART2;

class SeedFertilizerTest extends PuzzleSolutionTestBase {

    @BeforeEach
    void setUp() {
        this.underTest = new SeedFertilizer();
    }

    static Stream<Arguments> executeTests() {
        return Stream.of(
                Arguments.of(PART1, SAMPLE, 35L),
                Arguments.of(PART1, FULL, 525792406L),
                Arguments.of(PART2, SAMPLE, 46L)
//                Arguments.of(PART2, FULL, 79004094L) // - too slow
        );
    }
}