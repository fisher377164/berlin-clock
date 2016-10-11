package com.ubs.opsit.interviews.impl;

import com.ubs.opsit.interviews.TimeConverter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fisher
 * @since 10/11/16.
 */
public class BerlinClockTimeConverter implements TimeConverter {

    @Override
    public String convertTime(String aTime) {
        List<Integer> parts = Stream
                .of(aTime.split(":"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return getSeconds(parts.get(2)).concat("\n")
                .concat(getTopHours(parts.get(0))).concat("\n")
                .concat(getBottomHours(parts.get(0))).concat("\n")
                .concat(getTopMinutes(parts.get(1))).concat("\n")
                .concat(getBottomMinutes(parts.get(1)));
    }

    private String getSeconds(int number) {
        if (number % 2 == 0) {
            return "Y";
        } else {
            return "O";
        }
    }

    private String getTopHours(int number) {
        return getOnOff(4, getTopNumberOfOnLamps(number));
    }

    private String getBottomHours(int number) {
        return getOnOff(4, number % 5);
    }

    private String getTopMinutes(int number) {
        return getOnOff(11, getTopNumberOfOnLamps(number), "Y")
                .replaceAll("YYY", "YYR");
    }

    private String getBottomMinutes(int number) {
        return getOnOff(4, number % 5, "Y");
    }

    private String getOnOff(int lamps, int onSigns) {
        return getOnOff(lamps, onSigns, "R");
    }

    private String getOnOff(int lamps, int onSigns, String onSign) {
        String out = "";
        for (int i = 0; i < onSigns; i++) {
            out += onSign;
        }
        for (int i = 0; i < (lamps - onSigns); i++) {
            out += "O";
        }
        return out;
    }

    private int getTopNumberOfOnLamps(int number) {
        return (number - (number % 5)) / 5;
    }
}
