package com.ubs.opsit.interviews.impl;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.clock.BerlinClockTime;
import com.ubs.opsit.interviews.exception.InvalidTimeException;
import com.ubs.opsit.interviews.parser.TimeParser;

import static com.ubs.opsit.interviews.validation.TimeValidator.isTimeValid;

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
        if(!isTimeValid(aTime)){
            throw new InvalidTimeException(aTime);
        }
        TimeParser parser = new TimeParser(aTime);
        return new BerlinClockTime()
                .getBerlinClockTime(parser.getHours(), parser.getMinutes(), parser.getSeconds());
    }

}
