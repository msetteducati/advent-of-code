package com.msetteducati.y2023.d7;

import org.junit.jupiter.api.Test;

import static com.msetteducati.y2023.d7.Card.*;
import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void fromInput() {
        Hand hand = Hand.fromInput("32T3K 765");
        assertEquals(5, hand.getCards().length);
        assertEquals(THREE, hand.getCards()[0]);
        assertEquals(TWO, hand.getCards()[1]);
        assertEquals(TEN, hand.getCards()[2]);
        assertEquals(THREE, hand.getCards()[3]);
        assertEquals(KING, hand.getCards()[4]);
        assertEquals(765, hand.getBid());
    }
}