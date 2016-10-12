package com.ubs.opsit.interviews.custom.tests;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.exceptions.InvalidTimeException;
import com.ubs.opsit.interviews.impl.BerlinClockTimeConverter;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author fisher
 * @since 10/12/16.
 */
public class BerlinClockTimeConverterTest {

    private static TimeConverter converter;

    @BeforeClass
    public static void init() {
        converter = new BerlinClockTimeConverter();
    }

    @Test(expected = InvalidTimeException.class)
    public void testEmptyTime() {
        String invalidTime = "";

        converter.convertTime(invalidTime);
    }

    @Test(expected = InvalidTimeException.class)
    public void testInvalidTimeWithoutSeconds() {
        String invalidTime = "12:30";

        converter.convertTime(invalidTime);
    }

    @Test(expected = InvalidTimeException.class)
    public void testInvalidTime() {
        String invalidTime = "24:00:00";

        converter.convertTime(invalidTime);
    }

    @Test
    public void testMidnight() throws Exception {
        String time = "00:00:00";
        String expectedTime = "Y\n" +
                "OOOO\n" +
                "OOOO\n" +
                "OOOOOOOOOOO\n" +
                "OOOO";
        String actualTime = converter.convertTime(time);
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void testMiddleOfTheAfternoon() throws Exception {
        String time = "13:17:01";
        String expectedTime = "O\n" +
                "RROO\n" +
                "RRRO\n" +
                "YYROOOOOOOO\n" +
                "YYOO";
        String actualTime = converter.convertTime(time);
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void testJustBeforeMidnight() throws Exception {
        String time = "23:59:59";
        String expectedTime = "O\n" +
                "RRRR\n" +
                "RRRO\n" +
                "YYRYYRYYRYY\n" +
                "YYYY";
        String actualTime = converter.convertTime(time);
        assertEquals(expectedTime, actualTime);
    }
}
