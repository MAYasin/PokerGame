package org.poker.shuffler;

import org.poker.deck.Card;

import java.util.Collections;
import java.util.List;

/**
 * An implementation of a simple shuffler available in the Collections package.
 * @author muhammad.yasin
 */
public class GenericShuffler implements Shuffler {
    /**
     * Simple shuffler from the Collections package.
     * {@inheritDoc}
     */
    @Override
    public void shuffle(List<Card> cards) {
        Collections.shuffle(cards);
    }
}
