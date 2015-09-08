package org.bradleyhart.training;

import org.junit.Test;

import static org.bradleyhart.training.LineLimit.lineLimit;
import static org.bradleyhart.training.LineTruncator.lineTruncator;
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
        String result = lineTruncator(lineLimit(5)).truncate("some text");
        assertThat(result, is(equalTo("some\ntext")));
    }

    @Test
    public void shouldTruncateLineAtLineLimitWhenTwoLines(){
        String result = lineTruncator(lineLimit(5)).truncate("some text jim");
        assertThat(result, is(equalTo("some\ntext\njim")));
    }

    @Test
    public void shouldTruncateAtConfigurableValue(){
        String result = lineTruncator(lineLimit(3)).truncate("hi ho");
        assertThat(result, is(equalTo("hi\nho")));
    }

    @Test
    public void shouldOnlyTruncateOnSpace(){
        String result = lineTruncator(lineLimit(5)).truncate("hello me");
        assertThat(result, is(equalTo("hello\nme")));
    }

    @Test
    public void shouldOnlyTruncateOnSpaceWhenSpaceIsNotAfterLimit(){
        String result = lineTruncator(lineLimit(3)).truncate("hello me");
        assertThat(result, is(equalTo("hello\nme")));
    }

}
