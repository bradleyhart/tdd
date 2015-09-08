package org.bradleyhart.training;

public class LineTruncator {

    private LineLimit maxLineLimit;

    public LineTruncator(LineLimit maxLineLimit) {
        this.maxLineLimit = maxLineLimit;
    }

    public String truncate(String text) {
        StringBuilder truncatedText = new StringBuilder();
        LineState lineState = new LineState();

        for (int index = 0; index < text.length(); index++) {
            char character = text.charAt(index);

            if (maxLineLimit.isReachedOnSpace(index, character) || lineState.shouldTruncate(character)) {
                truncatedText.append('\n');
                lineState.resetLine();
            } else if (maxLineLimit.isReachedOnNonSpace(index, character)) {
                truncatedText.append(character);
                lineState.truncateOnNextSpace();
            } else {
                truncatedText.append(character);
            }
        }

        return truncatedText.toString();
    }

}
