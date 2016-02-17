package com.ubs.opsit.interviews.service;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class TimeConverterServiceException extends Exception {
    public TimeConverterServiceException() {
    }

    public TimeConverterServiceException(String message) {
        super(message);
    }

    public TimeConverterServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public TimeConverterServiceException(Throwable cause) {
        super(cause);
    }

    public TimeConverterServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
