package com.ubs.opsit.interviews.clock.impl;

import com.ubs.opsit.interviews.clock.Clock;

/**
 * @author fisher
 * @since 10/12/16.
 */
public class BerlinClock implements Clock {

    private static final String YELLOW_LAMP = "Y";
    private static final String RED_LAMP = "R";
    private static final String LIGHT_OFF = "O";
    private static final String INVALID_FIFTEEN_MINUTES_PANEL = "YYY";
    private static final String VALID_FIFTEEN_MINUTES_PANEL = "YYR";
    private static final String LINE_BREAK = "\n";
    private static final int HOURS_PANEL_LAMPS_NUMBER = 4;
    private static final int MINUTES_PANEL_LAMPS_NUMBER = 4;
    private static final int TOP_MINUTES_PANEL_LAMPS_NUMBER = 11;
    private static final int COUNT_TIME_IN_ONE_LAMP_AND_TOP_PANEL = 5;

    @Override
    public String getTime(int hours, int minutes, int seconds) {
        return getSeconds(seconds).concat(LINE_BREAK)
                .concat(getTopHours(hours)).concat(LINE_BREAK)
                .concat(getBottomHours(hours)).concat(LINE_BREAK)
                .concat(getTopMinutes(minutes)).concat(LINE_BREAK)
                .concat(getBottomMinutes(minutes));
    }

    private String getSeconds(int seconds) {
        if (isEven(seconds)) {
            return YELLOW_LAMP;
        } else {
            return LIGHT_OFF;
        }
    }

    private String getTopHours(int hours) {
        return getOnOffLampsInPanel(HOURS_PANEL_LAMPS_NUMBER, getTopNumberOfOnLamps(hours));
    }

    private String getBottomHours(int hours) {
        return getOnOffLampsInPanel(HOURS_PANEL_LAMPS_NUMBER, getActiveLampsInBottomPanel(hours));
    }

    private String getTopMinutes(int minutes) {
        return getOnOffLampsInPanel(TOP_MINUTES_PANEL_LAMPS_NUMBER, getTopNumberOfOnLamps(minutes), YELLOW_LAMP)
                .replaceAll(INVALID_FIFTEEN_MINUTES_PANEL, VALID_FIFTEEN_MINUTES_PANEL);
    }

    private String getBottomMinutes(int minutes) {
        return getOnOffLampsInPanel(MINUTES_PANEL_LAMPS_NUMBER, getActiveLampsInBottomPanel(minutes), YELLOW_LAMP);
    }

    private String getOnOffLampsInPanel(int lampsInPanel, int activeLamps) {
        return getOnOffLampsInPanel(lampsInPanel, activeLamps, RED_LAMP);
    }

    private String getOnOffLampsInPanel(int lampsInPanel, int activeLamps, String lampColor) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < activeLamps; i++) {
            builder.append(lampColor);
        }
        for (int i = 0; i < (lampsInPanel - activeLamps); i++) {
            builder.append(LIGHT_OFF);
        }
        return builder.toString();
    }

    private int getTopNumberOfOnLamps(int time) {
        return (time - (getActiveLampsInBottomPanel(time))) / COUNT_TIME_IN_ONE_LAMP_AND_TOP_PANEL;
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    private int getActiveLampsInBottomPanel(int time) {
        return time % COUNT_TIME_IN_ONE_LAMP_AND_TOP_PANEL;
    }
}
