package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.service.DeutscheTimeConverterService;
import com.ubs.opsit.interviews.service.TimeConverterService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class DeutscheTimeConverterImpl implements TimeConverter {


    private TimeConverterService timeConverterService = new DeutscheTimeConverterService(); // todo Ioc

    @Override
    public String convertTime(String aTime) {
        return timeConverterService.convertTime(aTime);
    }


}
