package com.example.wordscounter;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testSpaces() {
        WordCounter counter = new WordCounter();
        String input = "This is a test";
        int result = counter.countWords(input);
        assertEquals(4, result); // expects 4 words
    }

    @Test
    public void testCommas() {
        WordCounter counter = new WordCounter();
        String input = "apple,banana,orange";
        int result = counter.countWords(input);
        assertEquals(3, result); // expects 3 words
    }

    @Test
    public void testDots() {
        WordCounter counter = new WordCounter();
        String input = "one.two.three";
        int result = counter.countWords(input);
        assertEquals(3, result); // expects 3 words
    }

    @Test
    public void testMixedDelimiters() {
        WordCounter counter = new WordCounter();
        String input = "This, is. a test.";
        int result = counter.countWords(input);
        assertEquals(4, result); // expects 4 words
    }

    @Test
    public void testEmptyInput() {
        WordCounter counter = new WordCounter();
        String input = "";
        int result = counter.countWords(input);
        assertEquals(0, result); // expects 0 words
    }

    @Test
    public void testNullInput() {
        WordCounter counter = new WordCounter();
        String input = null;
        int result = counter.countWords(input);
        assertEquals(0, result); // expects 0 words
    }
}

class WordCounter {
    public int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        return text.trim().split("[ ,.]+").length;
    }
}

