package task;

public class ConcordancePresenter {

    private final Concordance concordance;

    public ConcordancePresenter(Concordance concordance) {
        this.concordance = concordance;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (ConcordanceEntry entry : this.concordance.getEntries()) {
            result.append(entryToString(entry));
            result.append("\n");
        }

        return result.toString();
    }

    private static String entryToString(ConcordanceEntry entry) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%s {%d:", entry.getWord(), entry.getSentenceIndices().size()));
        result.append(Utils.join(entry.getSentenceIndices(), ","));
        result.append("}");

        return result.toString();
    }
}
