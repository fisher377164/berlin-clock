package com.ubs.opsit.interviews.custom.tests;

import com.ubs.opsit.interviews.clock.Clock;
import com.ubs.opsit.interviews.clock.impl.BerlinClock;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author fisher
 * @since 10/12/16.
 */
public class BerlinClockTest {

    private static Clock clock;

    @BeforeClass
    public static void init() {
        clock = new BerlinClock();
    }

    @Test
    public void testMidnight24() {
        int hours = 24;
        int minutes = 0;
        int seconds = 0;
        String expectedTime = "Y\nRRRR\nRRRR\nOOOOOOOOOOO\nOOOO";
        String actualTime = clock.getTime(hours, minutes, seconds);
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void testMidnight() throws Exception {
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        String expectedTime = "Y\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO";
        String actualTime = clock.getTime(hours, minutes, seconds);
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void testMiddleOfTheAfternoon() throws Exception {
        int hours = 13;
        int minutes = 17;
        int seconds = 1;
        String expectedTime = "O\nRROO\nRRRO\nYYROOOOOOOO\nYYOO";
        String actualTime = clock.getTime(hours, minutes, seconds);
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void testJustBeforeMidnight() throws Exception {
        int hours = 23;
        int minutes = 59;
        int seconds = 59;
        String expectedTime = "O\nRRRR\nRRRO\nYYRYYRYYRYY\nYYYY";
        String actualTime = clock.getTime(hours, minutes, seconds);
        assertEquals(expectedTime, actualTime);
    }
}
