package com.ubs.opsit.interviews.custom.tests;

import com.ubs.opsit.interviews.validation.Time24HoursValidator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author fisher
 * @since 10/12/16.
 */
public class Time24HoursValidatorTest {

    @Test
    public void testInvalidHours() throws Exception {
        String time = "24:00:00";
        boolean actualResult = Time24HoursValidator.isTimeValid(time);
        assertFalse(actualResult);
    }

    @Test
    public void testInvalidMinutes() throws Exception {
        String time = "00:60:00";
        boolean actualResult = Time24HoursValidator.isTimeValid(time);
        assertFalse(actualResult);
    }

    @Test
    public void testInvalidSeconds() throws Exception {
        String time = "00:00:60";
        boolean actualResult = Time24HoursValidator.isTimeValid(time);
        assertFalse(actualResult);
    }

    @Test
    public void testEmptyTime() throws Exception {
        String time = "";
        boolean actualResult = Time24HoursValidator.isTimeValid(time);
        assertFalse(actualResult);
    }

    @Test
    public void testInvalidTime() throws Exception {
        String time = "Wed Oct 12, 23:55:02";
        boolean actualResult = Time24HoursValidator.isTimeValid(time);
        assertFalse(actualResult);
    }

    @Test
    public void testValidTime() throws Exception {
        String time = "00:00:00";
        boolean actualResult = Time24HoursValidator.isTimeValid(time);
        assertTrue(actualResult);
    }

    @Test
    public void testValidHours() throws Exception {
        String time = "01:00:00";
        boolean actualResult = Time24HoursValidator.isTimeValid(time);
        assertTrue(actualResult);
    }

    @Test
    public void testValidMinutes() throws Exception {
        String time = "00:01:00";
        boolean actualResult = Time24HoursValidator.isTimeValid(time);
        assertTrue(actualResult);
    }

    @Test
    public void testValidSeconds() throws Exception {
        String time = "00:00:01";
        boolean actualResult = Time24HoursValidator.isTimeValid(time);
        assertTrue(actualResult);
    }

    @Test
    public void testTopValidHours() throws Exception {
        String time = "23:00:00";
        boolean actualResult = Time24HoursValidator.isTimeValid(time);
        assertTrue(actualResult);
    }

    @Test
    public void testTopValidMinutes() throws Exception {
        String time = "00:59:00";
        boolean actualResult = Time24HoursValidator.isTimeValid(time);
        assertTrue(actualResult);
    }

    @Test
    public void testTopValidSeconds() throws Exception {
        String time = "00:00:59";
        boolean actualResult = Time24HoursValidator.isTimeValid(time);
        assertTrue(actualResult);
    }


}
