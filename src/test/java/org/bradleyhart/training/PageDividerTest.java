package org.bradleyhart.training;

import org.junit.Test;

import java.util.List;

import static org.bradleyhart.training.LineLimit.lineLimit;
import static org.bradleyhart.training.LineTruncator.lineTruncator;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class PageDividerTest {

    @Test
    public void shouldNotDivideForHigherLineLimit(){
        List<String> pages = new PageDivider(100, lineTruncator(lineLimit(25))).dividePages("on the first page");
        assertThat(pages.size(), is(1));
        assertThat(pages.get(0), is(equalTo("on the first page")));
    }

    @Test
    public void shouldNotDivideAcrossTwoPages(){
        List<String> pages = new PageDivider(2, lineTruncator(lineLimit(5))).dividePages("some text jim");
        assertThat(pages.size(), is(2));
        assertThat(pages.get(0), is(equalTo("some\ntext")));
        assertThat(pages.get(1), is(equalTo("jim")));
    }

}
