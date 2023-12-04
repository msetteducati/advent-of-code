package com.msetteducati.y2023.d2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Game {
    private int id;
    private List<Round> rounds;

    /**
     * From string in following format:
     * <pre>
     * Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
     * </pre>
     * @param str
     * @return
     */
    public static Game fromString(String str) {
        String[] gameSplit = str.split(":");
        String id = gameSplit[0].replace("Game ", "");
        
        String[] roundSplit = gameSplit[1].trim().split(";");
        List<Round> rounds = Arrays.stream(roundSplit)
                .map(roundStr -> Round.fromString(roundStr.trim()))
                .toList();
        
        return Game.builder()
                .id(Integer.parseInt(id))
                .rounds(rounds)
                .build();
    }
}
