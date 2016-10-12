package com.ubs.opsit.interviews.converter.impl;

import com.ubs.opsit.interviews.clock.Clock;
import com.ubs.opsit.interviews.clock.impl.BerlinClock;
import com.ubs.opsit.interviews.converter.TimeConverter;
import com.ubs.opsit.interviews.parser.TimeParser;
import com.ubs.opsit.interviews.parser.impl.BerlinClockTimeParser;

/**
 * @author fisher
 * @since 10/11/16.
 */
public class BerlinClockTimeConverter implements TimeConverter {

    /**
     * @param aTime time in format hh:mm:ss
     * @return converted time to Berlin Clock
     */

    @Override
    public String convertTime(String aTime) {
        TimeParser parser = new BerlinClockTimeParser(aTime);
        Clock clock = new BerlinClock();
        return clock.getTime(parser.getHours(), parser.getMinutes(), parser.getSeconds());
    }

}
