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

            if(truncateOnNextSpace){
                truncatedText.append('\n');
                truncateOnNextSpace = false;
            } else if (maxLineLimit.isReached(index) && character == ' ') {
                truncatedText.append('\n');
            } else if (maxLineLimit.isReached(index)) {
                truncatedText.append(character);
                truncateOnNextSpace = true;
            } else {
                truncatedText.append(character);
            }
        }

        return truncatedText.toString();
    }

}
