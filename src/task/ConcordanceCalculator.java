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

        for (int sentenceIndex = 0; sentenceIndex < sentencesCount; sentenceIndex++) {
            Sentence sentence = sentences.get(sentenceIndex);
            List<String> words = sentence.extractWords();

            for (String word : words) {
                result.addWord(word, sentenceIndex);
            }
        }

        return result;
    }
}
