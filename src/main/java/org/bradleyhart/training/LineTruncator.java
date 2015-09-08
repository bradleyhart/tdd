package org.bradleyhart.training;

import static java.util.stream.IntStream.range;

public class LineTruncator {

    private Limit maxLineLimit;

    public LineTruncator(Limit maxLineLimit) {
        this.maxLineLimit = maxLineLimit;
    }

    public String truncate(String text) {
        StringBuilder truncatedText = new StringBuilder();

        boolean truncateOnNextSpace = false;

        for (int index = 0; index < text.length(); index++) {
            char character = text.charAt(index);

            if(truncateOnNextSpace && character == ' '){
                truncatedText.append('\n');
                truncateOnNextSpace = false;
            } else if (limitReachedOnSpace(index, character)) {
                truncatedText.append('\n');
            } else if (limitReachedOnNonSpace(index, character)) {
                truncatedText.append(character);
                truncateOnNextSpace = true;
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
