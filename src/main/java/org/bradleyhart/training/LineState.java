package org.bradleyhart.training;

public class LineState {
    private boolean truncateOnNextSpace = false;

    public boolean shouldTruncate(char character) {
        return truncateOnNextSpace && character == ' ';
    }

    public void resetLine() {
        truncateOnNextSpace = false;
    }

    public void truncateOnNextSpace() {
        truncateOnNextSpace = true;
    }
}
