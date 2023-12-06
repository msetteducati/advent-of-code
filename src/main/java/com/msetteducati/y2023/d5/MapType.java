package com.msetteducati.y2023.d5;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public enum MapType {
    SEED_TO_SOIL("seed-to-soil"),
    SOIL_TO_FERTILIZER("soil-to-fertilizer"),
    FERTILIZER_TO_WATER("fertilizer-to-water"),
    WATER_TO_LIGHT("water-to-light"),
    LIGHT_TO_TEMPERATURE("light-to-temperature"),
    TEMPERATURE_TO_HUMIDITY("temperature-to-humidity"),
    HUMIDITY_TO_LOCATION("humidity-to-location");

    private final String mapName;

    public String getInputLineIndicator() {
        return this.mapName + " map:";
    }

    private static final Map<String, MapType> inputLineToMapType;

    static {
        inputLineToMapType = new HashMap<>();
        for (var mapType : MapType.values()) {
            inputLineToMapType.put(mapType.getInputLineIndicator(), mapType);
        }
    }

    public static MapType getByInputLine(String inputLine) {
        return inputLineToMapType.get(inputLine);
    }
}
