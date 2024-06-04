package org.poker.deck;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * A deck is made up of 52 cards.
 * @author muhammad.yasin
 */
@Getter
public class Deck {
    public static final int DEFAULT_DECK_SIZE = 52;
    private final List<Card> cards;

    /**
     * Build the deck of 52 cards.
     * Cards are made by the combination of ranks and suits.
     */
    public Deck() {
        cards = new ArrayList<>(DEFAULT_DECK_SIZE);

        for (Suit suit: Suit.values()) {
            for(Rank rank: Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    /**
     * Deal the amount of cards specified, if it is more than the cards available only deal the remainder.
     * @param amountToDeal The amount to deal out
     * @return cards that are dealt
     */
    public List<Card> deal(int amountToDeal) {
        List<Card> cardsDealt = new ArrayList<>(amountToDeal);

        if(amountToDeal > cards.size()) {
            cardsDealt.addAll(
                    cards.subList(0, cards.size())
            );
        } else {
            cardsDealt.addAll(
                    cards.subList(0, amountToDeal)
            );
        }

        cards.removeAll(cardsDealt);
        return cardsDealt;
    }
}
