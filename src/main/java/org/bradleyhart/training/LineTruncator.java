package org.bradleyhart.training;

public class LineTruncator {

    public LineTruncator(int maxLineLimit) {

    }

    public String truncate(String text) {
        StringBuilder truncatedText = new StringBuilder();

        for (int index = 0; index < text.length(); index++) {
            if((index + 1) % 5 == 0){
                truncatedText.append('\n');
            } else {
                truncatedText.append(text.charAt(index));
            }
        }

        return truncatedText.toString();
    }

}
