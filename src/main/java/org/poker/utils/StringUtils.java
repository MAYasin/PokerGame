package org.poker.utils;

/**
 * String utilities
 * @author muhammad.yasin
 */
public class StringUtils {
    private StringUtils() {
    }

    /**
     * @param value underscore string passed in
     * @return title case string
     */
    public static String upperCaseToTitleCase(String value) {
        String[] words = value.toLowerCase().split("_");

        StringBuilder titleCase = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                titleCase.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(' ');
            }
        }

        return titleCase.toString().trim();
    }
}