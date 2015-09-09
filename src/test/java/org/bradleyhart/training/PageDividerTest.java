package org.bradleyhart.training;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class PageDividerTest {

    @Test
    public void shouldPutOnFirstPageWhenNumberOfLinesPerPageIsLargerThanText(){
        List<String> pages = new PageDivider(100).dividePages("on the first page");

        assertThat(pages.size(), is(1));
        assertThat(pages.get(0), is(equalTo("on the first page")));
    }

}
