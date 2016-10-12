package com.ubs.opsit.interviews.custom.tests;

import com.ubs.opsit.interviews.exception.InvalidTimeException;
import com.ubs.opsit.interviews.parser.TimeParser;
import com.ubs.opsit.interviews.parser.impl.BerlinClockTimeParser;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author fisher
 * @since 10/12/16.
 */
public class BerlinClockTimeParserTest {

    private static TimeParser parser;

    @BeforeClass
    public static void init() {
        parser = new BerlinClockTimeParser();
    }

    @Test(expected = InvalidTimeException.class)
    public void testInvalidTimeWithoutSeconds() {
        String invalidTime = "10:19";
        parser.parseTime(invalidTime);
    }

    @Test(expected = InvalidTimeException.class)
    public void testInvalidTime() {
        String invalidTime = ":00:";
        parser.parseTime(invalidTime);
    }

    @Test(expected = InvalidTimeException.class)
    public void testEmptyTime() throws Exception {
        String invalidTime = "";
        parser.parseTime(invalidTime);
    }

    @Test
    public void testHours() throws Exception {
        String time = "12:00:00";
        int expectedHours = 12;
        parser.parseTime(time);
        int actualHours = parser.getHours();
        assertEquals(expectedHours, actualHours);
    }

    @Test
    public void testMinutes() throws Exception {
        String time = "00:15:00";
        int expectedMinutes = 15;
        parser.parseTime(time);
        int actualMinutes = parser.getMinutes();
        assertEquals(expectedMinutes, actualMinutes);
    }

    @Test
    public void testSeconds() throws Exception {
        String time = "00:00:16";
        int expectedSeconds = 16;
        parser.parseTime(time);
        int actualSeconds = parser.getSeconds();
        assertEquals(expectedSeconds, actualSeconds);
    }
}
