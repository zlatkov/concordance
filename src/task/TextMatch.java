package task;

public class TextMatch {

    private final int start;
    private final int end;

    public TextMatch(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() { return this.start; }

    public int getEnd() { return this.end; }
}
