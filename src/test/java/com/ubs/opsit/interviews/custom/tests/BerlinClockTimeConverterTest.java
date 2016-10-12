package com.ubs.opsit.interviews.custom.tests;

import com.ubs.opsit.interviews.converter.TimeConverter;
import com.ubs.opsit.interviews.converter.impl.BerlinClockTimeConverter;
import com.ubs.opsit.interviews.exception.InvalidTimeException;
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
        String expectedTime = "Y\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO";
        String actualTime = converter.convertTime(time);
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void testMiddleOfTheAfternoon() throws Exception {
        String time = "13:17:01";
        String expectedTime = "O\nRROO\nRRRO\nYYROOOOOOOO\nYYOO";
        String actualTime = converter.convertTime(time);
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void testJustBeforeMidnight() throws Exception {
        String time = "23:59:59";
        String expectedTime = "O\nRRRR\nRRRO\nYYRYYRYYRYY\nYYYY";
        String actualTime = converter.convertTime(time);
        assertEquals(expectedTime, actualTime);
    }
}
