package com.msetteducati.y2023.d8;

import com.msetteducati.PuzzleSolutionTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static com.msetteducati.model.FileType.*;
import static com.msetteducati.model.Part.PART1;
import static com.msetteducati.model.Part.PART2;

class HauntedWastelandTest extends PuzzleSolutionTestBase {

    @BeforeEach
    void setUp() {
        this.underTest = new HauntedWasteland();
    }

    static Stream<Arguments> executeTests() {
        return Stream.of(
                Arguments.of(PART1, SAMPLE, 2),
                Arguments.of(PART1, FULL, 20777),
                Arguments.of(PART2, SAMPLE_2, 6),
                Arguments.of(PART2, FULL, 13289612809129L)
        );
    }

}