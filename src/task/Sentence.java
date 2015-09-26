package task;


import java.util.ArrayList;
import java.util.List;

public class Sentence extends TextElement {
    private static final String WORDS_SPLIT_PATTERN = "\\s+";
    private static final String WORD_STRIP_PATTERN = "[!?.,(){}]";

    public Sentence(String text) {
        super(text);
    }

    public List<String> extractWords() {
        String[] textParts = this.getText().split(WORDS_SPLIT_PATTERN);
        List<String> words = new ArrayList<>();
        for (String part : textParts) {
            String word = part.replaceAll(WORD_STRIP_PATTERN, "");
            if (isValidWord(word)) {
                words.add(word.toLowerCase());
            }
        }

        return words;
    }

    private static boolean isValidWord(String word) {
        int wordSize = word.length();
        if (wordSize > 0) {
            boolean startsWithLetterOrDigit = Character.isLetterOrDigit(word.charAt(0));
            return startsWithLetterOrDigit;
        }

        return false;
    }
}
