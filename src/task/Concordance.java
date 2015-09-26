package task;

import java.util.*;

public class Concordance {

    private final Map<String, List<Integer>> words = new TreeMap<>();

    public void addWord(String word, int sentenceIndex) {
        List<Integer> sentenceIndices;

        if (!this.words.containsKey(word)) {
            sentenceIndices = new ArrayList<>();
            this.words.put(word, sentenceIndices);
        }
        else {
            sentenceIndices = this.words.get(word);
        }

        sentenceIndices.add(sentenceIndex);
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
