package org.bradleyhart.training;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/*
 * Requirements:
 * 1. A block of text should get truncated to a new line when the line length is reached
 * 2. A new word should not be split
 */
public class LineTruncatorTest {

    @Test
    public void shouldTruncateLineAtLineLimit(){
        String result = new LineTruncator(5).truncate("some text");
        assertThat(result, is(equalTo("some\ntext")));
    }

    @Test
    public void shouldTruncateLineAtLineLimitWhenTwoLines(){
        String result = new LineTruncator(5).truncate("some text jim");
        assertThat(result, is(equalTo("some\ntext\njim")));
    }

    @Test
    public void shouldTruncateAtConfigurableValue(){
        String result = new LineTruncator(3).truncate("hi ho");
        assertThat(result, is(equalTo("hi\nho")));
    }

}
