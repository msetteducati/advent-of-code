package com.msetteducati.y2023.d5;

import com.msetteducati.util.FileUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeedAlmanacTest {

    @Test
    void fromInputTest() {
        List<String> input = FileUtil.getLines("y2023/d5/sample-input.txt");
        SeedAlmanac seedAlmanac = SeedAlmanac.fromInputStrings(input);

        assertEquals(4, seedAlmanac.getSeeds().size());
        assertEquals(79, seedAlmanac.getSeeds().get(0));
        assertEquals(13, seedAlmanac.getSeeds().get(3));

        assertEquals(51, seedAlmanac.get(MapType.SEED_TO_SOIL, 99));
        assertEquals(1, seedAlmanac.get(MapType.SEED_TO_SOIL, 1));
        assertEquals(1, seedAlmanac.get(MapType.SOIL_TO_FERTILIZER, 16));
        assertEquals(59, seedAlmanac.get(MapType.HUMIDITY_TO_LOCATION, 96));
    }

}