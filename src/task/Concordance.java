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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, List<Integer>> entry : this.words.entrySet()) {
            result.append(entryToString(entry));
            result.append("\n");
        }

        return result.toString();
    }

    private static String entryToString(Map.Entry<String, List<Integer>> entry) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%s {%d:", entry.getKey(), entry.getValue().size()));
        result.append(Utils.join(entry.getValue(), ","));
        result.append("}");

        return result.toString();
    }
}
