package org.poker.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void testUpperCaseToTitleCase() {
        String upperCaseString = "FOUR_OF_A_KIND";
        String expectedString = "Four Of A Kind";
        assertEquals(
                expectedString,
                StringUtils.upperCaseToTitleCase(upperCaseString)
        );
    }

    @Test
    void testEmptyString() {
        String expectedString = "";
        assertEquals(
                expectedString,
                StringUtils.upperCaseToTitleCase("")
        );
    }
}