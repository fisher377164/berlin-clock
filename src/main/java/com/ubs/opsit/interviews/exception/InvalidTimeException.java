package com.ubs.opsit.interviews.exception;

/**
 * @author fisher
 * @since 10/12/16.
 */
public class InvalidTimeException extends BaseException {

    public InvalidTimeException(String time) {
        super(time);
    }
}
