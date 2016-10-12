package com.ubs.opsit.interviews.parser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fisher
 * @since 10/12/16.
 */
public class TimeParser {

    private static final String TIME_SEPARATOR = ":";

    private int hours;
    private int minutes;
    private int seconds;

    public TimeParser() {
    }

    public TimeParser(String time) {
        parseTime(time);
    }

    public void parseTime(String time) {
        List<Integer> parts = Stream
                .of(time.split(TIME_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
         this.hours = parts.get(0);
         this.minutes = parts.get(1);
         this.seconds = parts.get(2);
    }

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }
}
