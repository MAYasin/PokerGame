package org.poker.deck;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A Card is made up of a rank and a suit.
 * @author muhammad.yasin
 */
@Getter
@AllArgsConstructor
public class Card {
    private final Rank rank;
    private final Suit suit;

    /**
     * @return Display the card
     */
    @Override
    public String toString() {
        return rank.getDisplayValue() + suit.getDisplayValue();
    }
}
