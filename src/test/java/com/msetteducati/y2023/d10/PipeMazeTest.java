package com.msetteducati.y2023.d10;

import com.msetteducati.PuzzleSolutionTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static com.msetteducati.model.FileType.FULL;
import static com.msetteducati.model.FileType.SAMPLE;
import static com.msetteducati.model.Part.PART1;

class PipeMazeTest extends PuzzleSolutionTestBase {

    @BeforeEach
    void setUp() {
        this.underTest = new PipeMaze();
    }

    static Stream<Arguments> executeTests() {
        return Stream.of(
                Arguments.of(PART1, SAMPLE, 8),
                Arguments.of(PART1, FULL, 6842)
//                Arguments.of(PART2, SAMPLE, 0),
//                Arguments.of(PART2, FULL, 0)
        );
    }
}