package com.ubs.opsit.interviews.parser.impl;

import com.ubs.opsit.interviews.exception.InvalidTimeException;
import com.ubs.opsit.interviews.parser.TimeParser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.ubs.opsit.interviews.validation.Time24HoursValidator.isTimeValid;

/**
 * @author fisher
 * @since 10/12/16.
 */
public class BerlinClockTimeParser implements TimeParser {

    private static final String TIME_SEPARATOR = ":";

    private int hours;
    private int minutes;
    private int seconds;

    public BerlinClockTimeParser() {
    }

    public BerlinClockTimeParser(String time) {
        parseTime(time);
    }

    @Override
    public void parseTime(String time) {
        if(!isTimeValid(time)){
            throw new InvalidTimeException(time);
        }
        List<Integer> parts = Stream
                .of(time.split(TIME_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
         this.hours = parts.get(0);
         this.minutes = parts.get(1);
         this.seconds = parts.get(2);
    }

    @Override
    public int getHours() {
        return this.hours;
    }

    @Override
    public int getMinutes() {
        return this.minutes;
    }

    @Override
    public int getSeconds() {
        return this.seconds;
    }
}
