package org.poker.variants;

import org.poker.deck.Card;
import org.poker.deck.Deck;
import org.poker.deck.Rank;
import org.poker.deck.Suit;
import org.poker.utils.ListUtils;

import java.util.Collections;
import java.util.List;

/**
 * An implementation of a poker variant called Five card draw.
 * @author muhammad.yasin
 */
public class FiveCardDraw implements PokerVariant {
    public static final int HAND_SIZE = 5;
    private final Deck deck;

    /**
     * Initializes the poker variant with a new deck.
     */
    public FiveCardDraw() {
        this.deck = new Deck();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Card> deal() {
        return deck.deal(HAND_SIZE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String evaluate(List<Card> cards) {
        Collections.sort(cards);
        HandRanking handRanking = rankHand(cards);
        orderCards(cards, handRanking);
        return handRanking.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Deck getDeck() {
        return deck;
    }

    /**
     * @param cards in the hand.
     * @return the Hand ranking enum.
     * @author Daniel Dyer
     */
    private HandRanking rankHand(List<Card> cards) {
        int pairs = countPairs(cards);
        switch (pairs) {
            case 1:
                return HandRanking.PAIR;
            case 2:
                return HandRanking.TWO_PAIR;
            case 3:
                return HandRanking.THREE_OF_A_KIND;
            case 4:
                return HandRanking.FULL_HOUSE;
            case 6:
                return HandRanking.FOUR_OF_A_KIND;
            default: {
                assert pairs == 0 : "Unexpected pair count: " + pairs;
                boolean flush = isFlush(cards);
                boolean straight = isStraight(cards);
                if (flush && straight) {
                    // A royal flush is a straight flush from 10 to Ace.
                    Rank lowest = cards.get(HAND_SIZE - 1).getRank();
                    return lowest == Rank.TEN ? HandRanking.ROYAL_FLUSH : HandRanking.STRAIGHT_FLUSH;
                } else if (flush) {
                    return HandRanking.FLUSH;
                } else if (straight) {
                    return HandRanking.STRAIGHT;
                } else {
                    return HandRanking.HIGH_CARD;
                }
            }
        }
    }


    /**
     * Re-orders the cards in a hand so that the most significant cards(s) are
     * first.  For example, the highest ranked card is the most significant in
     * a straight or flush whereas the two matching cards are the most significant
     * in a hand that has one pair.
     * <p>
     * Once the hand is correctly ordered, two hands with the same ranking can
     * easily be compared to see which is better by comparing the most significant
     * card (if these are equivalent then the second most significant cards can
     * be compared and so on).
     * @author Daniel Dyer
     */
    private void orderCards(List<Card> cards, HandRanking ranking) {
        // Assumes that the cards are already sorted by rank, so for flushes, high
        // cards and most straights, there is nothing to do.
        switch (ranking) {
            case STRAIGHT_FLUSH:
            case STRAIGHT: {
                // If this hand is A, 2, 3, 4, 5, make sure ace is low.
                if (cards.get(0).getRank() == Rank.ACE && cards.get(1).getRank() == Rank.FIVE) {
                    Collections.rotate(cards, -1);
                }
                break;
            }
            case FOUR_OF_A_KIND: {
                // The matching four cards will all be next to each other, so the kicker
                // is either at the beginning or the end.  If it's at the beginning, it
                // needs to be moved to the end.
                if (cards.get(0).getRank() != cards.get(1).getRank()) {
                    Collections.rotate(cards, -1);
                }
                break;
            }
            case FULL_HOUSE: {
                // The three-of-a-kind is more important than the pair, so if the pair
                // is first, it needs to be moved to the end.
                if (cards.get(2).getRank() != cards.get(0).getRank()) // 3rd card is not the same as 1st.
                {
                    Collections.rotate(cards, -2);
                }
                break;
            }
            case THREE_OF_A_KIND: {
                int start = findPair(cards);
                ListUtils.shiftLeft(cards, start, 3, start);
                break;
            }
            case TWO_PAIR: {
                // The kicker will either be the first, third or fifth card.  If it is the first or third,
                // it needs to be moved.
                if (cards.get(0).getRank() != cards.get(1).getRank()) // Kicker is first card.
                {
                    Collections.rotate(cards, -1);
                } else if (cards.get(2).getRank() != cards.get(3).getRank()) // Kicker is third card.
                {
                    cards.add(cards.remove(2));
                }
                break;
            }
            case PAIR: {
                int start = findPair(cards);
                ListUtils.shiftLeft(cards, start, 2, start);
                break;
            }
        }
    }


    /**
     * @param cards in the hand.
     * @return number of times a card is repeated.
     * @author Daniel Dyer
     */
    private int findPair(List<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getRank() == cards.get(i + 1).getRank()) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Counts how many pairs occur within a 5-card hand.  This is with replacement,
     * so one card can appear in multiple pairs (these are pairs in the Cribbage sense
     * rather than the poker sense).  This number of pairs maps to a particular poker
     * hand ranking (1 = PAIR, 2 = TWO_PAIR, 3 = THREE_OF_A_KIND, 4 = FULL_HOUSE,
     * 6 = FOUR_OF_A_KIND).  If the number of pairs is zero, additional checks for a
     * straight or flush must be made.
     * <p>
     * This pair-counting algorithm for ranking poker hands was invented by David Brunger.
     *
     * @param cards The five cards that make up the poker hand.
     * @return The total number of times any individual card's rank matches that of another
     * card in the hand.
     * @author Daniel Dyer
     */
    private int countPairs(List<Card> cards) {
        int pairs = 0;
        int runLength = 1;
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getRank() == cards.get(i + 1).getRank()) {
                ++runLength;
                pairs += runLength - 1;
            } else {
                runLength = 1;
            }
        }
        return pairs;
    }


    /**
     * @return True if the hand is a flush (or straight-flush), false otherwise.
     * @author Daniel Dyer
     */
    private boolean isFlush(List<Card> cards) {
        if (cards.size() != HAND_SIZE) {
            return false;
        }
        Suit suit = cards.getFirst().getSuit();
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getSuit() != suit) {
                return false;
            }

        }
        return true;
    }


    /**
     * Assumes that there are no pairs in the hand and that the cards are sorted.
     *
     * @return True if the hand is a straight (or straight-flush), false otherwise.
     * @author Daniel Dyer
     */
    private boolean isStraight(List<Card> cards) {
        if (cards.size() != HAND_SIZE) {
            return false;
        }

        Rank highest = cards.get(0).getRank();
        Rank lowest = cards.get(HAND_SIZE - 1).getRank();
        if (highest.ordinal() - lowest.ordinal() == HAND_SIZE - 1) {
            return true;
        }
        // Check for wheel (A, 2, 3, 4, 5).
        else if (highest == Rank.ACE && lowest == Rank.TWO) {
            Rank highestExcludingAce = cards.get(1).getRank();
            return highestExcludingAce == Rank.FIVE;
        } else {
            return false;
        }
    }
}
