package com.msetteducati.y2023.d2;

import com.msetteducati.PuzzleSolutionTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static com.msetteducati.model.FileType.FULL;
import static com.msetteducati.model.Part.PART1;
import static com.msetteducati.model.Part.PART2;

class CubeConundrumTest extends PuzzleSolutionTestBase {

    @BeforeEach
    void setUp() {
        this.underTest = new CubeConundrum();
    }

    static Stream<Arguments> executeTests() {
        return Stream.of(
                Arguments.of(PART1, FULL, 2416L),
                Arguments.of(PART2, FULL, 63307L)
        );
    }
}
