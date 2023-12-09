package com.msetteducati.y2023.d7;

import com.msetteducati.PuzzleSolutionTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static com.msetteducati.model.FileType.FULL;
import static com.msetteducati.model.FileType.SAMPLE;
import static com.msetteducati.model.Part.PART1;
import static com.msetteducati.model.Part.PART2;

class CamelCardsTest extends PuzzleSolutionTestBase {

    @BeforeEach
    void setUp() {
        this.underTest = new CamelCards();
    }

    static Stream<Arguments> executeTests() {
        return Stream.of(
                Arguments.of(PART1, SAMPLE, 6440L),
                Arguments.of(PART1, FULL, 249726565L),
                Arguments.of(PART2, SAMPLE, 5905L),
                Arguments.of(PART2, FULL, 251135960L)
        );
    }
}