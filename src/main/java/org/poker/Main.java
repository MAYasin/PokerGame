package org.poker;

import org.poker.shuffler.GenericShuffler;
import org.poker.shuffler.Shuffler;
import org.poker.variants.FiveCardDraw;
import org.poker.variants.PokerVariant;

public class Main {
    public static void main(String[] args) {
        /*
        * Decide the shuffler and poker variant.
        * Then initialize it.
        */
        Shuffler shuffler = new GenericShuffler();
        PokerVariant pokerVariant = new FiveCardDraw();

        /*
        * Initialize the game and enjoy playing it.
        */
        PokerGame pokerGame = new PokerGame(shuffler, pokerVariant);
        pokerGame.play();
    }
}