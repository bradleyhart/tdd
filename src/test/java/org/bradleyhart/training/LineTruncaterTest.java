package org.bradleyhart.training;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/*
 * Requirements:
 * 1. A block of text should get truncated to a new line when the line length is reached
 * 2. A new word should not be split
 */
public class LineTruncaterTest {

    @Test
    public void shouldNotTruncateIfLengthIsLongerThanText(){
        LineTruncater lineTruncater = new LineTruncater(12);

        String result = lineTruncater.truncate("I saw a cat");
        assertThat(result, is(equalTo("I saw a cat")));
    }

    @Test
    public void shouldAddNewLineAtPosition(){
        LineTruncater lineTruncater = new LineTruncater(6);

        String result = lineTruncater.truncate("I saw a cat");
        assertThat(result, is(equalTo("I saw\n a cat")));
    }

    @Test
    public void shouldAddNewLineAtPositionWhenMoreThanOneNewLine(){
        LineTruncater lineTruncater = new LineTruncater(6);

        String result = lineTruncater.truncate("I saw a cat and a dog");
        assertThat(result, is(equalTo("I saw\n a cat\n and a\n dog")));
    }

    @Test
    public void shouldNotSpiltAWord(){
        LineTruncater lineTruncater = new LineTruncater(5);

        String result = lineTruncater.truncate("I saw a cat and a dog");
        assertThat(result, is(equalTo("I saw\n a cat\n and a\n dog")));
    }


}
