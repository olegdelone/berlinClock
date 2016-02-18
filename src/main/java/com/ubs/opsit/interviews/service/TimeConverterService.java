package com.ubs.opsit.interviews.service;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public interface TimeConverterService {
    String convertTime(String aTime) throws TimeConverterServiceException;
}
