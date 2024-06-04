package org.poker.deck;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    void testDeckCreation() {
        assertEquals(Deck.DEFAULT_DECK_SIZE, deck.getCards().size());
    }

    @Test
    void testDealHand() {
        int expectedHand = 5;
        assertEquals(expectedHand, deck.deal(expectedHand).size());
    }

    @Test
    void testDealHandMoreThanAvailableCards() {
        int expectedHand = deck.getCards().size();
        assertEquals(expectedHand, deck.deal(expectedHand + 1).size());
    }
}