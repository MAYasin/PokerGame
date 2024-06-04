package org.poker.deck;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * There are 4 suits, defined as an enum to make a card.
 * @author muhammad.yasin
 */
@Getter
@AllArgsConstructor
public enum Suit {
    HEARTS('♥'),
    DIAMONDS('♦'),
    SPADES('♠'),
    CLUBS('♣');

    private final char displayValue;
}
