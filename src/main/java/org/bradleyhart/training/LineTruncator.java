package org.bradleyhart.training;

public class LineTruncator {

    public LineTruncator(int maxLineLimit) {

    }

    public String truncate(String text) {
        StringBuilder truncatedText = new StringBuilder();

        for (int index = 0; index < text.length(); index++) {
            if(hasReachedLineLimit(index)){
                truncatedText.append('\n');
            } else {
                truncatedText.append(text.charAt(index));
            }
        }

        return truncatedText.toString();
    }

    private boolean hasReachedLineLimit(int index) {
        return (index + 1) % 5 == 0;
    }

}
