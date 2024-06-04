package org.poker;

import lombok.AllArgsConstructor;
import org.poker.deck.Card;
import org.poker.shuffler.Shuffler;
import org.poker.variants.PokerVariant;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Entry point to play a poker game.
 * @author muhammad.yasin
 */
@AllArgsConstructor
public class PokerGame {
    private final Shuffler shuffler;
    private final PokerVariant pokerVariant;

    /**
     * Plays out the poker game and prints the result to the console.
     */
    public void play() {
        shuffler.shuffle(
                pokerVariant.getDeck().getCards()
        );
        System.out.println("Shuffling ... Shuffling ... Shuffling ...");

        List<Card> hand = pokerVariant.deal();
        System.out.printf(
                "Your hand: %s \r\n", hand.stream().map(Card::toString).collect(Collectors.joining(" "))
        );

        System.out.printf("You have: %s \r\n", pokerVariant.evaluate(hand));
    }
}
