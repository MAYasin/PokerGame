package org.poker.deck;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A Card is made up of a rank and a suit.
 * @author muhammad.yasin
 */
@Getter
@AllArgsConstructor
public class Card implements Comparable<Card> {
    private final Rank rank;
    private final Suit suit;

    /**
     * @param o the object to be compared.
     * @return if equal or not
     */
    @Override
    public int compareTo(Card o) {
        if (this.rank != o.rank) {
            return o.rank.ordinal() - this.rank.ordinal();
        } else {
            return this.suit.ordinal() - o.suit.ordinal();
        }
    }

    /**
     * @return Display the card
     */
    @Override
    public String toString() {
        return rank.getDisplayValue() + suit.getDisplayValue();
    }
}
