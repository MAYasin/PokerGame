package org.poker.utils;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ListUtilsTest {

    @Test
    void testShiftLeft() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        ListUtils.shiftLeft(list, 2, 1, 2);
        List<String> expectedList = Arrays.asList("c", "a", "b", "d", "e");

        assertEquals(expectedList, list);
    }
}