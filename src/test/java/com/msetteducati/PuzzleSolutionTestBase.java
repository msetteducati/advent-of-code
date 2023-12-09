package com.msetteducati;

import com.msetteducati.model.FileType;
import com.msetteducati.model.Part;
import com.msetteducati.model.PuzzleSolution;
import com.msetteducati.util.FileUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class PuzzleSolutionTestBase {

    protected final String year;
    protected final String day;
    protected PuzzleSolution underTest;

    protected PuzzleSolutionTestBase() {
        // This is a hack to get the year and day from the package name so I don't have to put it in every test constructor
        String[] packageSplit = this.getClass().getPackageName().split("\\.");
        this.year = packageSplit[2];
        this.day =  packageSplit[3];
    }

    @ParameterizedTest
    @MethodSource
    public void executeTests(Part part, FileType fileType, long expectedOutput) {
        List<String> input = FileUtil.getLines(getFileName(fileType));
        var result = switch(part) {
            case PART1 -> underTest.part1(input);
            case PART2 -> underTest.part2(input);
        };
        System.out.println(result);
        assertEquals(expectedOutput, result);
    }

    protected String getFileName(FileType fileType) {
        return String.format("%s/%s/%s", year, day, fileType.getFileName());
    }
}
