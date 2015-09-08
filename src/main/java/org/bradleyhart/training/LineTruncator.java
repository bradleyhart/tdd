package org.bradleyhart.training;

import static java.util.stream.IntStream.range;

public class LineTruncator {

    public LineTruncator(int maxLineLimit) {

    }

    public String truncate(String text) {
        StringBuilder truncatedText = new StringBuilder();

        range(0, text.length()).forEach(index -> {
            if(hasReachedLineLimit(index)){
                truncatedText.append('\n');
            } else {
                truncatedText.append(text.charAt(index));
            }
        });

        return truncatedText.toString();
    }

    private boolean hasReachedLineLimit(int index) {
        return (index + 1) % 5 == 0;
    }

}
