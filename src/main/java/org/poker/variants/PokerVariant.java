package org.poker.variants;

import org.poker.deck.Card;
import org.poker.deck.Deck;

import java.util.List;

/**
 * An interface to create different poker variant games.
 * @author muhammad.yasin
 */
public interface PokerVariant {
    /**
     * @return a hand of cards.
     */
    List<Card> deal();

    /**
     * @param cards in the hand.
     * @return evaluation of the hand.
     */
    String evaluate(List<Card> cards);

    /**
     * @return the deck used in the poker variant.
     */
    Deck getDeck();
}
