package task;

import java.util.regex.Pattern;

public final class Patterns {
    public static final Pattern ABBREVIATIONS_PATTERN;

    // Terminators are ".", "!", "?"  or they can be wrapped ".)", "!]" etc.
    public static final Pattern TERMINATORS_PATTERN = Pattern.compile("[.?!][)}\\]]?");

    // Abbreviations are special words such as e.g., i.e., dr.
    private static final String[] ABBREVIATIONS = new String[] { "e.g.", "mr.", "i.e.", "dr." };

    static {
        StringBuilder abbreviationsPattern = new StringBuilder();
        int abbreviationsCount = ABBREVIATIONS.length;

        for (int i = 0; i < abbreviationsCount; i++) {
            String abbreviation = ABBREVIATIONS[i];
            String abbreviationPattern = getAbbreviationPattern(abbreviation);

            if (i > 0) {
                abbreviationsPattern.append("|");
            }

            abbreviationsPattern.append(abbreviationPattern);
        }

        ABBREVIATIONS_PATTERN = Pattern.compile(abbreviationsPattern.toString());
    }

    private static String getAbbreviationPattern(String abbreviation) {
        StringBuilder result = new StringBuilder();
        for (char symbol : abbreviation.toCharArray()) {
            if (symbol == '.') {
                result.append("\\.");
            }
            else {
                result.append(symbol);
            }
        }

        return result.toString();
    }
}
