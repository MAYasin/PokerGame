package org.poker.variants;

import org.poker.utils.StringUtils;

/**
 * @author muhammad.yasin
 */
public enum HandRanking {
    HIGH_CARD,
    PAIR,
    TWO_PAIR,
    THREE_OF_A_KIND,
    STRAIGHT,
    FLUSH,
    FULL_HOUSE,
    FOUR_OF_A_KIND,
    STRAIGHT_FLUSH,
    ROYAL_FLUSH;

    /**
     * @return enum as title case string.
     */
    @Override
    public String toString() {
        return StringUtils.upperCaseToTitleCase(super.toString());
    }
}
