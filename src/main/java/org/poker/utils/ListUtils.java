package org.poker.utils;

import java.util.Collections;
import java.util.List;

/**
 * List utilities
 * @author Daniel Dyer
 */
public class ListUtils {
    private ListUtils() {
    }

    /**
     * @param list     The list to manipulate.
     * @param start    The index at which the sub list starts.
     * @param length   The length of the sub list.
     * @param distance The number of positions to move the sub list.
     */
    public static void shiftLeft(List<?> list,
                                 int start,
                                 int length,
                                 int distance) {
        for (int i = 0; i < distance; i++) {
            for (int j = 0; j < length; j++) {
                int index = (start - i) + j;
                Collections.swap(list, index, index - 1);
            }
        }
    }
}
