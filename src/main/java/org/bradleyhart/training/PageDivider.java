package org.bradleyhart.training;


import java.util.ArrayList;
import java.util.List;

public class PageDivider {

    private LineTruncator lineTruncator;
    private LinesPerPage linesPerPage;

    public PageDivider(LinesPerPage linesPerPage, LineTruncator lineTruncator) {
        this.linesPerPage = linesPerPage;
        this.lineTruncator = lineTruncator;
    }

    public List<Page> dividePages(String text) {
        String truncatedText = lineTruncator.truncate(text);
        String[] lines = truncatedText.split("\n");

        List<Page> pages = new ArrayList<Page>();

        Page page = new Page();
        for (int index = 0; index < lines.length; index++) {
            page.addLine(lines[index]);

            if(linesPerPage.hasReachedLimit(index)){
                pages.add(page);
                page = new Page();
            } else if(index != (lines.length - 1)) {
                page.newLine();
            }
        }

        pages.add(page);

        return pages;
    }
}
