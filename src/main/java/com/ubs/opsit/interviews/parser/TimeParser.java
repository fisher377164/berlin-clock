package com.ubs.opsit.interviews.parser;

/**
 * @author fisher
 * @since 10/12/16.
 */
public interface TimeParser {

    void parseTime(String time);

    int getHours();

    int getMinutes();

    int getSeconds();

}
