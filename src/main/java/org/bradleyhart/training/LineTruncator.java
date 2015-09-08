package org.bradleyhart.training;

public class LineTruncator {

    private LineLimit maxLineLimit;

    private LineTruncator(LineLimit maxLineLimit) {
        this.maxLineLimit = maxLineLimit;
    }

    public String truncate(String text) {
        StringBuilder truncatedText = new StringBuilder();
        DelayedTruncateState delayedTruncateState = new DelayedTruncateState();

        for (int index = 0; index < text.length(); index++) {
            char character = text.charAt(index);

            if (maxLineLimit.isReachedOnSpace(index, character) || delayedTruncateState.shouldTruncate(character)) {
                truncate(truncatedText, delayedTruncateState);
            } else {
                truncatedText.append(character);
            }

            if (maxLineLimit.isReachedOnNonSpace(index, character)) {
                delayedTruncateState.truncateOnNextSpace();
            }
        }

        return truncatedText.toString();
    }

    private void truncate(StringBuilder truncatedText, DelayedTruncateState delayedTruncateState) {
        truncatedText.append('\n');
        delayedTruncateState.reset();
    }

    public static LineTruncator lineTruncator(LineLimit limit){
        return new LineTruncator(limit);
    }

}
