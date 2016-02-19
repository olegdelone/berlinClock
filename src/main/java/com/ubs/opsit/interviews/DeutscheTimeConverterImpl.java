package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.service.DeutscheTimeConverterService;
import com.ubs.opsit.interviews.service.TimeConverterService;
import com.ubs.opsit.interviews.service.TimeConverterServiceException;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class DeutscheTimeConverterImpl implements TimeConverter {


    private TimeConverterService timeConverterService = new DeutscheTimeConverterService(); // todo Ioc

    @Override
    public String convertTime(String aTime) {
        try {
            return timeConverterService.convertTime(aTime);
        } catch (TimeConverterServiceException e) {
            throw new RuntimeException(e);
        }
    }


}
