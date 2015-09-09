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
        List<String> pages = new ArrayList<String>();
        StringBuilder currentPage = new StringBuilder();

        String[] lines = lineTruncator.truncate(text).split("\n");

        for (int index = 0; index < lines.length; index++) {
            addLine(currentPage, lines[index]);

            if(isOnLimit(index)){
                addCurrentPage(pages, currentPage);
                currentPage = new StringBuilder();
            } else if (!isLastLine(lines, index)) {
                addNewLine(currentPage);
            }
        }

        return addCurrentPage(pages, currentPage);
    }

    private void addLine(StringBuilder currentPage, String line) {
        currentPage.append(line);
    }

    private void addNewLine(StringBuilder currentPage) {
        currentPage.append('\n');
    }

    private List<String> addCurrentPage(List<String> pages, StringBuilder currentPage) {
        pages.add(currentPage.toString());
        return pages;
    }

    private boolean isLastLine(String[] lines, int index) {
        return index == (lines.length - 1);
    }

    private boolean isOnLimit(int index) {
        return (index + 1) % lineLimit == 0;
    }

}
