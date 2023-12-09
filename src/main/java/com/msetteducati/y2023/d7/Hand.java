package com.msetteducati.y2023.d7;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Builder
public class Hand implements Comparable<Hand> {

    private static final int HAND_SIZE = 5;

    @Getter(AccessLevel.PROTECTED)
    private final Card[] cards;

    @Getter
    private final int bid;

    private HandValue handValue;

    public HandValue getHandValue() {
        if (handValue != null) {
            return this.handValue;
        }

        Map<Card, Integer> cardMap = Arrays.stream(cards)
                .collect(Collectors.toMap(Function.identity(), card -> 1, Integer::sum));

        int numJokers = cardMap.getOrDefault(Card.JOKER, 0);
        if (numJokers != HAND_SIZE) {
            cardMap.remove(Card.JOKER);
            Card cardHighestCount = cardMap.entrySet().stream()
                    .max(Comparator.comparingInt(Map.Entry::getValue))
                    .map(Map.Entry::getKey)
                    .orElseGet(() -> cardMap.entrySet().stream().toList().get(0).getKey()); // If every card is in there once, it doesn't matter
            cardMap.put(cardHighestCount, cardMap.get(cardHighestCount) + numJokers);
        }

        if (cardMap.size() == 1) {
            this.handValue = HandValue.FIVE_OF_A_KIND;
        } else if (cardMap.size() == 2) {
            if (cardMap.containsValue(4)) {
                this.handValue = HandValue.FOUR_OF_A_KIND;
            } else {
                this.handValue = HandValue.FULL_HOUSE;
            }
        } else if (cardMap.size() == 3) {
            if (cardMap.containsValue(3)) {
                this.handValue = HandValue.THREE_OF_A_KIND;
            } else {
                this.handValue = HandValue.TWO_PAIR;
            }
        } else if (cardMap.size() == 4) {
            this.handValue = HandValue.ONE_PAIR;
        } else {
            this.handValue = HandValue.HIGH_CARD;
        }

        return this.handValue;
    }

    @Override
    public int compareTo(Hand otherHand) {
        int compareHandValue = Integer.compare(this.getHandValue().getRank(), otherHand.getHandValue().getRank());
        return compareHandValue != 0
                ? compareHandValue
                : compareCardOrder(otherHand);
    }

    private int compareCardOrder(Hand otherHand) {
        for (int i = 0; i < HAND_SIZE; i++) {
            if (this.getCards()[i] != otherHand.getCards()[i]) {
                return this.getCards()[i].getRank() - otherHand.getCards()[i].getRank();
            }
        }
        return 0;
    }

    public static Hand fromInput(String input) {
        String[] split = input.split(" ");
        return Hand.builder()
                .cards(split[0].chars()
                        .mapToObj(c -> (char) c)
                        .map(Card::fromLabel)
                        .toArray(Card[]::new))
                .bid(Integer.parseInt(split[1].trim()))
                .build();
    }
}
