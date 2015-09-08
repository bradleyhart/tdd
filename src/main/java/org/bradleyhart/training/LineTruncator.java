package org.bradleyhart.training;

public class LineTruncator {

    private LineLimit maxLineLimit;

    public LineTruncator(LineLimit maxLineLimit) {
        this.maxLineLimit = maxLineLimit;
    }

    public String truncate(String text) {
        StringBuilder truncatedText = new StringBuilder();
        DelayedTruncateState delayedTruncateState = new DelayedTruncateState();

        for (int index = 0; index < text.length(); index++) {
            char character = text.charAt(index);

            if (maxLineLimit.isReachedOnSpace(index, character) || delayedTruncateState.shouldTruncate(character)) {
                truncatedText.append('\n');
                delayedTruncateState.reset();
            } else {
                truncatedText.append(character);
            }

            if (maxLineLimit.isReachedOnNonSpace(index, character)) {
                delayedTruncateState.truncateOnNextSpace();
            }
        }

        return truncatedText.toString();
    }

}
