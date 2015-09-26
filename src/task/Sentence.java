package task;


import java.util.ArrayList;
import java.util.List;

public class Sentence extends TextElement {

    private static final String WORDS_SPLIT = "\\s+"; // One or more whitespaces.

    public Sentence(String text) {
        super(text);
    }

    public List<String> extractWords() {
        String[] textParts = this.getText().split(WORDS_SPLIT);
        List<String> words = new ArrayList<>();

        for (String part : textParts) {
            String word = removeInvalidBoundaryCharacters(part).toLowerCase();

            if (isAbbreviation(word)) {
                words.add(word);
            }
            else {
                word = removeTrailingDots(word);

                if (isValidWord(word)) {
                    words.add(word);
                }
            }
        }

        return words;
    }

    private static String removeTrailingDots(String word) {
        return word.replaceAll("\\.+$", ""); // One or more dots at the end of the word.
    }

    private static String removeInvalidBoundaryCharacters(String word) {
        int wordSize = word.length();
        int beginIndex = 0;

        while (beginIndex < wordSize && !isValidBoundaryCharacter(word.charAt(beginIndex))) {
            beginIndex++;
        }

        int endIndex = wordSize - 1;

        while (endIndex > 0 && endIndex > beginIndex && !isValidBoundaryCharacter(word.charAt(endIndex))) {
            endIndex--;
        }

        return word.substring(beginIndex, endIndex + 1);
    }

    private static boolean isValidBoundaryCharacter(char ch) {
        return Character.isLetterOrDigit(ch) || ch == '.';
    }

    private static boolean isAbbreviation(String word) {
        return word.matches(Patterns.ABBREVIATIONS_PATTERN.pattern());
    }

    private static boolean isValidWord(String word) {
        return word.length() > 0;
    }
}
