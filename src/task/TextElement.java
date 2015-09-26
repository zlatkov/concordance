package task;

public abstract class TextElement {

    private final String text;

    public TextElement(String text) {
        this.text = text;
    }

    public String getText() { return this.text; }
}
