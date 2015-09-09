package org.bradleyhart.training;

import java.util.ArrayList;
import java.util.List;

public class PageDivider {

    private int lineLimit;
    private LineTruncator lineTruncator;

    public PageDivider(int lineLimit, LineTruncator lineTruncator) {
        this.lineLimit = lineLimit;
        this.lineTruncator = lineTruncator;
    }

    public List<String> dividePages(String text) {
        String truncated = lineTruncator.truncate(text);

        List<String> pages = new ArrayList<String>();
        StringBuilder page = new StringBuilder();

        String[] lines = truncated.split("\n");

        for (int index = 0; index < lines.length; index++) {
            page.append(lines[index]);

            if((index + 1) % lineLimit == 0){
                pages.add(page.toString());
                page = new StringBuilder();
            } else if (index != (lines.length - 1)) {
                page.append('\n');
            }
        }

        pages.add(page.toString());

        return pages;
    }

}
