package org.poker.shuffler;

import org.junit.jupiter.api.Test;
import org.poker.deck.Card;
import org.poker.deck.Rank;
import org.poker.deck.Suit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericShufflerTest {

    @Test
    void testShuffle() {
        GenericShuffler shuffler = new GenericShuffler();

        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.ACE, Suit.SPADES));
        cards.add(new Card(Rank.JACK, Suit.CLUBS));
        cards.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        cards.add(new Card(Rank.KING, Suit.HEARTS));

        List<Card> originalOrder = new ArrayList<>(cards);

        shuffler.shuffle(cards);

        assertNotEquals(cards, originalOrder);
    }
}