package com.msetteducati.y2023.d6;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GrandPrix {
    private List<Race> races;

    public static GrandPrix fromInputPart1(List<String> input) {
        var times = Arrays.stream(input.get(0).split(" "))
                .filter(s -> !s.isEmpty())
                .filter(s -> !s.equals("Time:"))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        var distances = Arrays.stream(input.get(1).split(" "))
                .filter(s -> !s.isEmpty())
                .filter(s -> !s.equals("Distance:"))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        List<Race> races = new ArrayList<>();
        for (int i = 0; i < times.size(); i++) {
            Race race = Race.builder()
                    .time(times.get(i))
                    .recordDistance(distances.get(i))
                    .build();
            races.add(race);
        }

        return GrandPrix.builder()
                .races(races)
                .build();
    }

    public static GrandPrix fromInputPart2(List<String> input) {
        return GrandPrix.builder()
                .races(List.of(Race.builder()
                                .time(getNumPart2(input.get(0)))
                                .recordDistance(getNumPart2(input.get(1)))
                        .build()))
                .build();
    }

    private static long getNumPart2(String input) {
        String numStr = input.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isDigit)
                .collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString));
        return Long.parseLong(numStr);
    }
}
