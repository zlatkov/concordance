package task;


import java.util.ArrayList;
import java.util.List;

public class Sentence extends TextElement {

    private static final String WORDS_SPLIT = "\\s+";

    public Sentence(String text) {
        super(text);
    }

    public List<String> extractWords() {
        String[] textParts = this.getText().split(WORDS_SPLIT);
        List<String> words = new ArrayList<>();
        for (String part : textParts) {
            String word = removeInvalidBoundaryCharacters(part);
            if (isAbbreviation(word)) {
                words.add(word.toLowerCase());
            }
            else {
                String validWord = removeTrailingDot(word);
                words.add(validWord.toLowerCase());
            }
        }

        return words;
    }

    private static String removeTrailingDot(String word) {
        return word.replaceAll("\\.$", "");
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
}
