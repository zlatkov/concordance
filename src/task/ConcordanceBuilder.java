package task;

import java.util.List;

public class ConcordanceBuilder {

    private final TextDocument textDocument;

    public ConcordanceBuilder(String text) {
        this.textDocument = new TextDocument(text);
    }

    public Concordance build() {
        Concordance result = new Concordance();
        List<Sentence> sentences = this.textDocument.extractSentences();
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
