package com.msetteducati.y2023.d4;

import com.msetteducati.PuzzleSolutionTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static com.msetteducati.model.FileType.FULL;
import static com.msetteducati.model.FileType.SAMPLE;
import static com.msetteducati.model.Part.PART1;
import static com.msetteducati.model.Part.PART2;

class ScratchcardsTest extends PuzzleSolutionTestBase {

    @BeforeEach
    void setUp() {
        this.underTest = new Scratchcards();
    }

    static Stream<Arguments> executeTests() {
        return Stream.of(
                Arguments.of(PART1, SAMPLE, 13L),
                Arguments.of(PART1, FULL, 25651L),
                Arguments.of(PART2, SAMPLE, 30L),
                Arguments.of(PART2, FULL, 19499881L)
        );
    }
}