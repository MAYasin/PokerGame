package org.poker.deck;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * There are 13 ranks, defined as an enum to make a card.
 * @author muhammad.yasin
 */
@Getter
@AllArgsConstructor
public enum Rank {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private final String displayValue;
}
