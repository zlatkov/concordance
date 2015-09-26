package task;

import java.util.List;

public class ConcordanceEntry {

    private final String word;
    private final List<Integer> sentenceIndices;

    public ConcordanceEntry(String word, List<Integer> sentenceIndices) {
        this.word = word;
        this.sentenceIndices = sentenceIndices;
    }

    public String getWord() { return this.word; }

    public List<Integer> getSentenceIndices() { return this.sentenceIndices; }
}
