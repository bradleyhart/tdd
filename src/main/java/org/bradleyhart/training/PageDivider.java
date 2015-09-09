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
        String[] lines = toLines(text);

        List<Page> pages = new ArrayList<Page>();
        Page currentPage = new Page();

        for (int index = 0; index < lines.length; index++) {
            currentPage.addLine(lines[index]);

            if(linesPerPage.hasReachedLimit(index)){
                pages.add(currentPage);
                currentPage = new Page();
            } else if(isNotLastLine(lines, index)) {
                currentPage.newLine();
            }
        }

        pages.add(currentPage);

        return pages;
    }

    private boolean isNotLastLine(String[] lines, int index) {
        return index != (lines.length - 1);
    }

    private String[] toLines(String text) {
        return lineTruncator.truncate(text).split("\n");
    }
}
