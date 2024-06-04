package org.poker.shuffler;

import org.poker.deck.Card;

import java.util.List;

/**
 * An interface to create different shuffler variants.
 * @author muhammad.yasin
 */
public interface Shuffler {
    /**
     * Shuffle should cater for a list of cards and not a fixed deck.
     * @param cards shuffles a list of cards.
     */
    void shuffle(List<Card> cards);
}
