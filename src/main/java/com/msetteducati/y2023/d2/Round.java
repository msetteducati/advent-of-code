package com.msetteducati.y2023.d2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Round {
    private Map<Color, Integer> dice;

    public void setDice(Color color, int count) {
        this.dice.put(color, count);
    }

    public int getCount(Color color) {
        return this.dice.getOrDefault(color, 0);
    }

    /**
     * From string in following format:
     * <pre>
     * 3 blue, 4 red
     * </pre>
     * @param str
     * @return
     */
    public static Round fromString(String str) {
        Map<Color, Integer> dice = new HashMap<>();
        Arrays.stream(str.split(","))
                .map(diceStr -> diceStr.trim().split(" "))
                .forEach(diceSplit -> {
                    Color color = Color.valueOf(diceSplit[1].toUpperCase(Locale.ROOT));
                    int count = Integer.parseInt(diceSplit[0]);
                    dice.put(color, count);
                });

        return Round.builder()
                .dice(dice)
                .build();
    }
}
