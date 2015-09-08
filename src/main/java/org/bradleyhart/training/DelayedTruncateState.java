package org.bradleyhart.training;

public class DelayedTruncateState {

    private boolean truncateOnNextSpace = false;

    public boolean shouldTruncate(char character) {
        return truncateOnNextSpace && character == ' ';
    }

    public void reset() {
        truncateOnNextSpace = false;
    }

    public void truncateOnNextSpace() {
        truncateOnNextSpace = true;
    }

}
