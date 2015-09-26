package task;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class Patterns {

    public static final Pattern ABBREVIATIONS_PATTERN;

    // Terminators are ".", "!", "?"  or they can be wrapped ".)", "!]" etc.
    public static final Pattern TERMINATORS_PATTERN = Pattern.compile("[.?!][)}\\]]?");

    // Abbreviations are special words such as e.g., i.e., dr.
    private static final String[] ABBREVIATIONS = new String[] { "e.g.", "mr.", "i.e.", "dr." };

    static {
        List<String> abbreviationPatterns = new ArrayList<>();

        for (String abbreviation : ABBREVIATIONS) {
            String abbreviationPattern = getAbbreviationPattern(abbreviation);
            abbreviationPatterns.add(abbreviationPattern);
        }

        String pattern = Utils.join(abbreviationPatterns, "|");
        ABBREVIATIONS_PATTERN = Pattern.compile(pattern);
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
