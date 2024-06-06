package org.poker.variants;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.poker.deck.Card;
import org.poker.deck.Deck;
import org.poker.deck.Rank;
import org.poker.deck.Suit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FiveCardDrawTest {
    private FiveCardDraw fiveCardDraw;

    @BeforeEach
    void setUp() {
        fiveCardDraw = new FiveCardDraw();
    }

    @Test
    void testDeal() {
        List<Card> hand = fiveCardDraw.deal();
        assertEquals(FiveCardDraw.HAND_SIZE, hand.size());
    }

    @Test
    void testGetDeck() {
        FiveCardDraw fiveCardDraw = new FiveCardDraw();

        assertEquals(Deck.DEFAULT_DECK_SIZE, fiveCardDraw.getDeck().getCards().size());
    }

    @Test
    public void testEvaluateHighCard() {
        FiveCardDraw fiveCardDraw = new FiveCardDraw();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Rank.KING, Suit.DIAMONDS));
        hand.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        hand.add(new Card(Rank.SEVEN, Suit.SPADES));
        hand.add(new Card(Rank.FOUR, Suit.SPADES));
        hand.add(new Card(Rank.THREE, Suit.HEARTS));

        String evaluation = fiveCardDraw.evaluate(hand);

        assertEquals(HandRanking.HIGH_CARD.toString(), evaluation);
    }

    @Test
    public void testEvaluateOnePair() {
        FiveCardDraw fiveCardDraw = new FiveCardDraw();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Rank.TEN, Suit.SPADES));
        hand.add(new Card(Rank.TEN, Suit.HEARTS));
        hand.add(new Card(Rank.EIGHT, Suit.SPADES));
        hand.add(new Card(Rank.SEVEN, Suit.HEARTS));
        hand.add(new Card(Rank.FOUR, Suit.CLUBS));

        String evaluation = fiveCardDraw.evaluate(hand);

        assertEquals(HandRanking.PAIR.toString(), evaluation);
    }

    @Test
    public void testEvaluateTwoPair() {
        FiveCardDraw fiveCardDraw = new FiveCardDraw();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Rank.JACK, Suit.HEARTS));
        hand.add(new Card(Rank.JACK, Suit.SPADES));
        hand.add(new Card(Rank.THREE, Suit.CLUBS));
        hand.add(new Card(Rank.THREE, Suit.SPADES));
        hand.add(new Card(Rank.TWO, Suit.HEARTS));

        String evaluation = fiveCardDraw.evaluate(hand);

        assertEquals(HandRanking.TWO_PAIR.toString(), evaluation);
    }

    @Test
    public void testEvaluateThreeOfAKind() {
        FiveCardDraw fiveCardDraw = new FiveCardDraw();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Rank.QUEEN, Suit.CLUBS));
        hand.add(new Card(Rank.QUEEN, Suit.SPADES));
        hand.add(new Card(Rank.QUEEN, Suit.HEARTS));
        hand.add(new Card(Rank.NINE, Suit.HEARTS));
        hand.add(new Card(Rank.TWO, Suit.SPADES));

        String evaluation = fiveCardDraw.evaluate(hand);

        assertEquals(HandRanking.THREE_OF_A_KIND.toString(), evaluation);
    }

    @Test
    public void testEvaluateStraight() {
        FiveCardDraw fiveCardDraw = new FiveCardDraw();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Rank.TEN, Suit.DIAMONDS));
        hand.add(new Card(Rank.NINE, Suit.SPADES));
        hand.add(new Card(Rank.EIGHT, Suit.HEARTS));
        hand.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
        hand.add(new Card(Rank.SIX, Suit.CLUBS));

        String evaluation = fiveCardDraw.evaluate(hand);

        assertEquals(HandRanking.STRAIGHT.toString(), evaluation);
    }

    @Test
    public void testEvaluateFlush() {
        FiveCardDraw fiveCardDraw = new FiveCardDraw();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Rank.JACK, Suit.DIAMONDS));
        hand.add(new Card(Rank.NINE, Suit.DIAMONDS));
        hand.add(new Card(Rank.EIGHT, Suit.DIAMONDS));
        hand.add(new Card(Rank.FOUR, Suit.DIAMONDS));
        hand.add(new Card(Rank.THREE, Suit.DIAMONDS));

        String evaluation = fiveCardDraw.evaluate(hand);

        assertEquals(HandRanking.FLUSH.toString(), evaluation);
    }

    @Test
    public void testEvaluateFullHouse() {
        FiveCardDraw fiveCardDraw = new FiveCardDraw();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Rank.SIX, Suit.SPADES));
        hand.add(new Card(Rank.SIX, Suit.HEARTS));
        hand.add(new Card(Rank.SIX, Suit.DIAMONDS));
        hand.add(new Card(Rank.KING, Suit.CLUBS));
        hand.add(new Card(Rank.KING, Suit.HEARTS));

        String evaluation = fiveCardDraw.evaluate(hand);

        assertEquals(HandRanking.FULL_HOUSE.toString(), evaluation);
    }

    @Test
    public void testEvaluateFourOfAKind() {
        FiveCardDraw fiveCardDraw = new FiveCardDraw();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Rank.FIVE, Suit.CLUBS));
        hand.add(new Card(Rank.FIVE, Suit.DIAMONDS));
        hand.add(new Card(Rank.FIVE, Suit.HEARTS));
        hand.add(new Card(Rank.FIVE, Suit.SPADES));
        hand.add(new Card(Rank.TEN, Suit.DIAMONDS));

        String evaluation = fiveCardDraw.evaluate(hand);

        assertEquals(HandRanking.FOUR_OF_A_KIND.toString(), evaluation);
    }

    @Test
    public void testEvaluateStraightFlush() {
        FiveCardDraw fiveCardDraw = new FiveCardDraw();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Rank.JACK, Suit.CLUBS));
        hand.add(new Card(Rank.TEN, Suit.CLUBS));
        hand.add(new Card(Rank.NINE, Suit.CLUBS));
        hand.add(new Card(Rank.EIGHT, Suit.CLUBS));
        hand.add(new Card(Rank.SEVEN, Suit.CLUBS));

        String evaluation = fiveCardDraw.evaluate(hand);

        assertEquals(HandRanking.STRAIGHT_FLUSH.toString(), evaluation);
    }

    @Test
    public void testEvaluateRoyalFlush() {
        FiveCardDraw fiveCardDraw = new FiveCardDraw();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Rank.ACE, Suit.SPADES));
        hand.add(new Card(Rank.KING, Suit.SPADES));
        hand.add(new Card(Rank.QUEEN, Suit.SPADES));
        hand.add(new Card(Rank.JACK, Suit.SPADES));
        hand.add(new Card(Rank.TEN, Suit.SPADES));

        String evaluation = fiveCardDraw.evaluate(hand);

        assertEquals(HandRanking.ROYAL_FLUSH.toString(), evaluation);
    }

    @Test
    public void testUnSortedPair() {
        FiveCardDraw fiveCardDraw = new FiveCardDraw();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Rank.ACE, Suit.DIAMONDS));
        hand.add(new Card(Rank.TEN, Suit.HEARTS));
        hand.add(new Card(Rank.KING, Suit.SPADES));
        hand.add(new Card(Rank.TEN, Suit.CLUBS));
        hand.add(new Card(Rank.FIVE, Suit.CLUBS));

        String evaluation = fiveCardDraw.evaluate(hand);

        assertEquals(HandRanking.PAIR.toString(), evaluation);
    }

    @Test
    public void testUnSortedThreeOfAKind() {
        FiveCardDraw fiveCardDraw = new FiveCardDraw();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Rank.TEN, Suit.DIAMONDS));
        hand.add(new Card(Rank.ACE, Suit.HEARTS));
        hand.add(new Card(Rank.TEN, Suit.SPADES));
        hand.add(new Card(Rank.KING, Suit.CLUBS));
        hand.add(new Card(Rank.TEN, Suit.CLUBS));

        String evaluation = fiveCardDraw.evaluate(hand);

        assertEquals(HandRanking.THREE_OF_A_KIND.toString(), evaluation);
    }
}