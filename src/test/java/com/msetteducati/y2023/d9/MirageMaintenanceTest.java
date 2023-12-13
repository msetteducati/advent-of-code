package com.msetteducati.y2023.d9;

import com.msetteducati.PuzzleSolutionTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static com.msetteducati.model.FileType.FULL;
import static com.msetteducati.model.FileType.SAMPLE;
import static com.msetteducati.model.Part.PART1;
import static com.msetteducati.model.Part.PART2;

class MirageMaintenanceTest extends PuzzleSolutionTestBase {

    @BeforeEach
    void setUp() {
        this.underTest = new MirageMaintenance();
    }

    static Stream<Arguments> executeTests() {
        return Stream.of(
                Arguments.of(PART1, SAMPLE, 114),
                Arguments.of(PART1, FULL, 1637452029),
                Arguments.of(PART2, SAMPLE, 2),
                Arguments.of(PART2, FULL, 908)
        );
    }
}