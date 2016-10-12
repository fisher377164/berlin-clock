package com.ubs.opsit.interviews.clocks;

/**
 * @author fisher
 * @since 10/12/16.
 */
public class BerlinClockTime {

    private static final String YELLOW_LAMP = "Y";
    private static final String RED_LAMP = "R";
    private static final String LIGHT_OFF = "O";
    private static final String INVALID_FIFTEEN_MINUTES_PANEL = "YYY";
    private static final String VALID_FIFTEEN_MINUTES_PANEL = "YYR";
    private static final int HOURS_PANEL_LAMPS_NUMBER = 4;
    private static final int MINUTES_PANEL_LAMPS_NUMBER = 4;
    private static final int TOP_MINUTES_PANEL_LAMPS_NUMBER = 11;
    private static final String LINE_BREAK = "\n";


    public String getBerlinClockTime(int hours, int minutes, int seconds) {
        return getSeconds(seconds).concat(LINE_BREAK)
                .concat(getTopHours(hours)).concat(LINE_BREAK)
                .concat(getBottomHours(hours)).concat(LINE_BREAK)
                .concat(getTopMinutes(minutes)).concat(LINE_BREAK)
                .concat(getBottomMinutes(minutes));
    }

    private String getSeconds(int number) {
        if (isEven(number)) {
            return YELLOW_LAMP;
        } else {
            return LIGHT_OFF;
        }
    }

    private String getTopHours(int number) {
        return getOnOff(HOURS_PANEL_LAMPS_NUMBER, getTopNumberOfOnLamps(number));
    }

    private String getBottomHours(int number) {
        return getOnOff(HOURS_PANEL_LAMPS_NUMBER, number % 5);
    }

    private String getTopMinutes(int number) {
        return getOnOff(TOP_MINUTES_PANEL_LAMPS_NUMBER, getTopNumberOfOnLamps(number), YELLOW_LAMP)
                .replaceAll(INVALID_FIFTEEN_MINUTES_PANEL, VALID_FIFTEEN_MINUTES_PANEL);
    }

    private String getBottomMinutes(int number) {
        return getOnOff(MINUTES_PANEL_LAMPS_NUMBER, number % 5, YELLOW_LAMP);
    }

    private String getOnOff(int lamps, int onSigns) {
        return getOnOff(lamps, onSigns, RED_LAMP);
    }

    private String getOnOff(int lamps, int onSigns, String onSign) {
        String out = "";
        for (int i = 0; i < onSigns; i++) {
            out += onSign;
        }
        for (int i = 0; i < (lamps - onSigns); i++) {
            out += LIGHT_OFF;
        }
        return out;
    }

    private int getTopNumberOfOnLamps(int number) {
        return (number - (number % 5)) / 5;
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
