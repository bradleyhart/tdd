package org.bradleyhart.training;


import java.util.ArrayList;
import java.util.List;

public class PageDivider {

    private LineTruncator lineTruncator;
    private int linesPerPage;

    public PageDivider(int linesPerPage, LineTruncator lineTruncator) {
        this.linesPerPage = linesPerPage;
        this.lineTruncator = lineTruncator;
    }

    public List<String> dividePages(String text) {
        String truncatedText = lineTruncator.truncate(text);
        String[] lines = truncatedText.split("\n");

        List<String> pages = new ArrayList<String>();

        StringBuilder page = new StringBuilder();
        for (int index = 0; index < lines.length; index++) {
            page.append(lines[index]);

            if((index + 1) % linesPerPage == 0){
                pages.add(page.toString());
                page = new StringBuilder();
            } else if(index != (lines.length - 1)) {
                page.append('\n');
            }
        }

        pages.add(page.toString());

        return pages;
    }
}
