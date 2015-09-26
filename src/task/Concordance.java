package task;

import java.util.*;

public class Concordance {

    private final Map<String, List<Integer>> words = new TreeMap<>();

    public void addWord(String word, int sentenceIndex) {
        List<Integer> sentenceIndexes;

        if (!this.words.containsKey(word)) {
            sentenceIndexes = new ArrayList<>();
            this.words.put(word, sentenceIndexes);
        }
        else {
            sentenceIndexes = this.words.get(word);
        }

        sentenceIndexes.add(sentenceIndex);
    }

    public List<ConcordanceEntry> getEntries() {
        List<ConcordanceEntry> concordanceEntries = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry : this.words.entrySet()) {
            ConcordanceEntry concordanceEntry = new ConcordanceEntry(entry.getKey(), entry.getValue());
            concordanceEntries.add(concordanceEntry);
        }

        return concordanceEntries;
    }
}
