package org.bradleyhart.training;

import static java.util.stream.IntStream.range;

public class LineTruncator {

    private Limit maxLineLimit;

    public LineTruncator(Limit maxLineLimit) {
        this.maxLineLimit = maxLineLimit;
    }

    public String truncate(String text) {
        StringBuilder truncatedText = new StringBuilder();

        final boolean[] truncateOnNextSpace = {false};
        range(0, text.length()).forEach(index -> {
            char character = text.charAt(index);

            if(truncateOnNextSpace[0]){
                truncatedText.append('\n');
                truncateOnNextSpace[0] = false;
            } else if (maxLineLimit.isReached(index) && character == ' ') {
                truncatedText.append('\n');
            } else if (maxLineLimit.isReached(index)) {
                truncatedText.append(character);
                truncateOnNextSpace[0] = true;
            } else {
                truncatedText.append(character);
            }
        });

        return truncatedText.toString();
    }

}
