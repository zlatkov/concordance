package task;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class Patterns {

    public static final Pattern ABBREVIATIONS_PATTERN;

    // Terminators are the characters ".", "!", "?".
    // They can also be wrapped like ".)", "!]" etc.
    public static final Pattern TERMINATORS_PATTERN = Pattern.compile("[.?!][)}\\]]?");

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
        // Every '.' should be replaced with '\.' for a valid Pattern.
        return abbreviation.replaceAll("\\.", "\\\\.");
    }
}
