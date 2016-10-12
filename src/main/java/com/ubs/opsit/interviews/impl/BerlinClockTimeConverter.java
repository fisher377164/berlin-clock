package com.ubs.opsit.interviews.impl;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.exceptions.InvalidTimeException;
import com.ubs.opsit.interviews.parser.TimeParser;
import com.ubs.opsit.interviews.validation.TimeValidator;
import com.ubs.opsit.interviews.clocks.BerlinClockTime;

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
        if(!(new TimeValidator().isTimeValid(aTime))){
            throw new InvalidTimeException(aTime);
        }
        TimeParser parser = new TimeParser(aTime);
        return new BerlinClockTime()
                .getBerlinClockTime(parser.getHours(), parser.getMinutes(), parser.getSeconds());
    }

}
