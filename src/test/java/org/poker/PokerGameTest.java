package org.poker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.poker.deck.Card;
import org.poker.deck.Deck;
import org.poker.deck.Rank;
import org.poker.deck.Suit;
import org.poker.shuffler.GenericShuffler;
import org.poker.shuffler.Shuffler;
import org.poker.variants.FiveCardDraw;
import org.poker.variants.PokerVariant;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PokerGameTest {

    @Mock
    private Shuffler shuffler;

    @Mock
    private PokerVariant pokerVariant;

    @Mock
    private Deck deck;

    @Test
    void testPlay() {
        List<Card> expectedHand = new ArrayList<>();
        expectedHand.add(new Card(Rank.ACE, Suit.SPADES));
        expectedHand.add(new Card(Rank.KING, Suit.HEARTS));

        when(pokerVariant.getDeck()).thenReturn(deck);

        when(deck.getCards()).thenReturn(expectedHand);
        when(pokerVariant.deal()).thenReturn(expectedHand);
        when(pokerVariant.evaluate(expectedHand)).thenReturn("Four Of A Kind");

        PokerGame pokerGame = new PokerGame(shuffler, pokerVariant);
        pokerGame.play();

        verify(shuffler).shuffle(expectedHand);
        verify(pokerVariant).getDeck();
        verify(pokerVariant).deal();
        verify(pokerVariant).evaluate(expectedHand);
    }
}