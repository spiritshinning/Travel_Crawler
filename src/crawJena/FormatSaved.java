package crawJena;

public abstract class FormatSaved {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    abstract String getFormat(String text);
}
