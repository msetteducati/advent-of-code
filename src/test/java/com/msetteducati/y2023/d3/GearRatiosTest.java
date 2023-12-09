package com.msetteducati.y2023.d3;

import com.msetteducati.PuzzleSolutionTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static com.msetteducati.model.FileType.FULL;
import static com.msetteducati.model.FileType.SAMPLE;
import static com.msetteducati.model.Part.PART1;
import static com.msetteducati.model.Part.PART2;

class GearRatiosTest extends PuzzleSolutionTestBase {

    @BeforeEach
    void setUp() {
        this.underTest = new GearRatios();
    }

    static Stream<Arguments> executeTests() {
        return Stream.of(
                Arguments.of(PART1, SAMPLE, 4361L),
                Arguments.of(PART1, FULL, 557705L),
                Arguments.of(PART2, SAMPLE, 467835L),
                Arguments.of(PART2, FULL, 84266818L)
        );
    }
}
