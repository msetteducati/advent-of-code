package com.msetteducati.y2023.d5;

import lombok.*;

import java.util.*;

public class SeedAlmanac {

    @Getter
    private final List<Long> seeds;

    private final Map<MapType, List<Mapping>> map;

    public SeedAlmanac(List<Long> seeds) {
        this.seeds = seeds;
        this.map = new HashMap<>();
        for (var mapType : MapType.values()) {
            this.map.put(mapType, new ArrayList<>());
        }
    }

    public long get(MapType mapType, long source) {
        for (var mapping : this.map.get(mapType)) {
            if (source >= mapping.sourceStart && source <= mapping.sourceEnd) {
                return source + mapping.offset;
            }
        }

        return source;
    }

    public void put(MapType mapType, long source, long length, long offset) {
        // Ex:
        // 57 7 4
        // (7, 10) -> +50 (= 57, 60)
        Mapping mapping = Mapping.builder()
                .sourceStart(source)
                .sourceEnd(source + length - 1)
                .offset(offset)
                .build();
        this.map.get(mapType).add(mapping);
    }

    @Data
    @AllArgsConstructor
    @Builder
    private static class Mapping {
        private final long sourceStart;
        private final long sourceEnd;
        private final long offset;
    }

    public static SeedAlmanac fromInputStrings(List<String> input) {
        List<Long> seeds = Arrays.stream(input.get(0)
                .replace("seeds: ", "")
                .trim()
                .split(" "))
                .map(Long::parseLong)
                .toList();

        SeedAlmanac seedAlmanac = new SeedAlmanac(seeds);

        for (int i = 1; i < input.size(); i++) {
            var mapType = MapType.getByInputLine(input.get(i));
            if (mapType != null) {
                for (int j = i + 1; j < input.size() && !input.get(j).equals(""); j++, i++) {
                    List<Long> line = Arrays.stream(input.get(j).split(" "))
                            .map(Long::parseLong)
                            .toList();

                    long destination = line.get(0);
                    long source = line.get(1);
                    long length = line.get(2);
                    long offset = destination - source;

                    seedAlmanac.put(mapType, source, length, offset);
                }
            }
        }

        return seedAlmanac;
    }
}
