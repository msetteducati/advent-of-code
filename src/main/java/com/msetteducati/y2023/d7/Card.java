package com.msetteducati.y2023.d7;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum Card {
    ACE(14, 'A'),
    KING(13, 'K'),
    QUEEN(12, 'Q'),
    JACK(11, 'J'),
    TEN(10, 'T'),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2),
    JOKER(1, 'R');

    private final int rank;
    private final char label;

    Card(int rank) {
        this(rank, String.valueOf(rank).charAt(0));
    }

    private static final Map<Character, Card> cardTypeMap;

    static {
        cardTypeMap = new HashMap<>();
        for (var cardType : Card.values()) {
            cardTypeMap.put(cardType.label, cardType);
        }
    }

    public static Card fromLabel(char label) {
        return cardTypeMap.get(label);
    }
}
