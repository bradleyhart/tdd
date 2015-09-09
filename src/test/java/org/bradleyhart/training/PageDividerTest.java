package org.bradleyhart.training;

import org.junit.Test;

import java.util.List;

import static org.bradleyhart.training.LinesPerPage.linesPerPage;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PageDividerTest {

    private LineTruncator lineTruncator = mock(LineTruncator.class);

    @Test
    public void shouldPutOnFirstPageWhenNumberOfLinesPerPageIsLargerThanText(){
        when(lineTruncator.truncate("on the first page")).thenReturn("on the first page");

        List<Page> pages = new PageDivider(linesPerPage(100), lineTruncator).dividePages("on the first page");

        assertThat(pages.size(), is(1));
        assertThat(pages.get(0).getText(), is(equalTo("on the first page")));
    }

    @Test
    public void shouldPutTextOnSecondPage(){
        when(lineTruncator.truncate("some text jim")).thenReturn("some\ntext\njim");

        List<Page> pages = new PageDivider(linesPerPage(2), lineTruncator).dividePages("some text jim");

        assertThat(pages.size(), is(2));
        assertThat(pages.get(0).getText(), is(equalTo("some\ntext")));
        assertThat(pages.get(1).getText(), is(equalTo("jim")));
    }

}
