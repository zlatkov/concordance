package task;

public class TextMatch {

    private int position;
    private String text;

    public TextMatch(int position, String text) {
        this.position = position;
        this.text = text;
    }

    public int getStart() { return this.position; }

    public int getEnd() { return this.position + this.text.length() - 1; }
}
