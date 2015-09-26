package task;

import java.util.List;

public class ConcordanceCalculator {

    private Paragraph paragraph;

    public ConcordanceCalculator(String text) {
        this.paragraph = new Paragraph(text);
    }

    public Concordance calculate() {
        Concordance result = new Concordance();
        List<Sentence> sentences = this.paragraph.extractSentences();
        int sentencesCount = sentences.size();
        for (int i = 0; i < sentencesCount; i++) {
            Sentence sentence = sentences.get(i);
            List<String> words = sentence.extractWords();
            for (String word : words) {
                result.addWord(word, i);
            }
        }

        return result;
    }
}
