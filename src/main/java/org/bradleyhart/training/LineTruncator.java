package org.bradleyhart.training;

import static java.util.stream.IntStream.range;

public class LineTruncator {

    private Limit maxLineLimit;

    public LineTruncator(Limit maxLineLimit) {
        this.maxLineLimit = maxLineLimit;
    }

    public String truncate(String text) {
        StringBuilder truncatedText = new StringBuilder();

        range(0, text.length()).forEach(index -> {
            if(maxLineLimit.isReached(index)){
                truncatedText.append('\n');
            } else {
                truncatedText.append(text.charAt(index));
            }
        });

        return truncatedText.toString();
    }

}
