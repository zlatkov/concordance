package task;

import java.util.*;

public class Paragraph extends TextElement {

    public Paragraph(String text) {
        super(text);
    }

    public List<Sentence> extractSentences() {
        List<TextMatch> possibleSentenceEndings = Utils.findMatches(this.getText(), Patterns.TERMINATORS_PATTERN);
        List<TextMatch> abbreviations = Utils.findMatches(this.getText(), Patterns.ABBREVIATIONS_PATTERN);

        int textPosition = 0;
        List<Sentence> sentences = new ArrayList<>();

        for (TextMatch ending : possibleSentenceEndings) {
            if (isValidSentenceEnd(ending, abbreviations)) {
                String sentenceText = this.getText().substring(textPosition, ending.getEnd() + 1);
                Sentence sentence = new Sentence(sentenceText);
                sentences.add(sentence);
                textPosition = ending.getEnd() + 1;
            }
        }

        return sentences;
    }

    private static boolean isValidSentenceEnd(TextMatch ending, List<TextMatch> abbreviations) {
        for (TextMatch abbreviation : abbreviations) {
            if (ending.getStart() >= abbreviation.getStart() && ending.getEnd() <= abbreviation.getEnd()) {
                return false;
            }
        }

        return true;
    }
}
