package org.poker.deck;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    private Card card;

    @BeforeEach
    void setUp() {
        card = new Card(Rank.ACE, Suit.SPADES);
    }

    @Test
    void testToString() {
        String expectedString = "A♠";
        assertEquals(expectedString, card.toString());
    }

    @Test
    void testGetRank() {
        assertEquals(Rank.ACE, card.getRank());
    }

    @Test
    void testGetSuit() {
        assertEquals(Suit.SPADES, card.getSuit());
    }
}