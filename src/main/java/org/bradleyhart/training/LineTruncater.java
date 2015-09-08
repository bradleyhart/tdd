package org.bradleyhart.training;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class LineTruncater {

    public static final String NEW_LINE = "\n";

    private int lineLengthLimit;

    public LineTruncater(int lineLengthLimit) {
        this.lineLengthLimit = lineLengthLimit;
    }

    public String truncate(String text) {
        List<String> truncatedText = new ArrayList<String>();

        char[] rawText = text.toCharArray();


        boolean hasHitLineLimit = false;
        for (int index = 0; index < rawText.length; index++){
            hasHitLineLimit = isOnLineLimit(index);
            boolean isOnWord = rawText[index] != ' ';

            if(hasHitLineLimit && !isOnWord){
                truncatedText.add(NEW_LINE);
                hasHitLineLimit = false;
            }

            truncatedText.add(String.valueOf(rawText[index]));
        }

        return truncatedText.stream().collect(joining());
    }

    private boolean isOnLineLimit(int index) {
        return (index + 1) % lineLengthLimit == 0;
    }

}
