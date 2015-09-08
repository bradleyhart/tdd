package org.bradleyhart.training;

public class LineTruncator {

    private Limit maxLineLimit;

    public LineTruncator(Limit maxLineLimit) {
        this.maxLineLimit = maxLineLimit;
    }

    public String truncate(String text) {
        StringBuilder truncatedText = new StringBuilder();

        LineState lineState = new LineState();

        for (int index = 0; index < text.length(); index++) {
            char character = text.charAt(index);

            if (limitReachedOnSpace(index, character) || lineState.shouldTruncate(character)) {
                truncatedText.append('\n');
                lineState.resetLine();
            } else if (limitReachedOnNonSpace(index, character)) {
                truncatedText.append(character);
                lineState.truncateOnNextSpace();
            } else {
                truncatedText.append(character);
            }
        }

        return truncatedText.toString();
    }

    private boolean limitReachedOnNonSpace(int index, char character) {
        return maxLineLimit.isReached(index) && character != ' ';
    }

    private boolean limitReachedOnSpace(int index, char character) {
        return maxLineLimit.isReached(index) && character == ' ';
    }

}
