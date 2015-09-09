package org.bradleyhart.training;

public class Page {

    private StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    public void addLine(String line) {
        text.append(line);
    }

    public void newLine() {
        text.append('\n');
    }
}
