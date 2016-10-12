package com.ubs.opsit.interviews.validation;

import java.util.regex.Pattern;

/**
 * @author fisher
 * @since 10/12/16.
 */

public class Time24HoursValidator {

    private static final String TIME_PATTERN =
            "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";

    private static Pattern pattern = Pattern.compile(TIME_PATTERN);

    public static boolean isTimeValid(String time) {
        return pattern.matcher(time).matches();
    }
}
