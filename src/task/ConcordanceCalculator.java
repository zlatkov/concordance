package task;

import java.util.List;

public class ConcordanceCalculator {

    private final Paragraph paragraph;

    public ConcordanceCalculator(String text) {
        this.paragraph = new Paragraph(text);
    }

    public Concordance calculate() {
        Concordance result = new Concordance();
        List<Sentence> sentences = this.paragraph.extractSentences();
        int sentenceIndex = 0;

        for (Sentence sentence : sentences) {
            List<String> words = sentence.extractWords();

            for (String word : words) {
                result.addWord(word, sentenceIndex);
            }

            sentenceIndex++;
        }

        return result;
    }
}
