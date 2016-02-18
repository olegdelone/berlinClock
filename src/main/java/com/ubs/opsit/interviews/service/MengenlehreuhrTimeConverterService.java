package com.ubs.opsit.interviews.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.ubs.opsit.interviews.model.clock.MengenlehreuhrClock;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class MengenlehreuhrTimeConverterService implements TimeConverterService{
    MengenlehreuhrClock mengenlehreuhrClock = new MengenlehreuhrClock();

    @Override
    public String convertTime(String aTime) throws TimeConverterServiceException{
        DateFormat format = new SimpleDateFormat("HH:mm:ss"); // not thread safe
        Date date;

        try {
            date = format.parse(aTime);

        } catch (ParseException e) {
            throw new TimeConverterServiceException(e);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int mnts = calendar.get(Calendar.MINUTE);
        int scnds = calendar.get(Calendar.SECOND);

        int hrs = 24; //todo rude workaround
        if(aTime.equals(format.format(date))){
            hrs = calendar.get(Calendar.HOUR_OF_DAY);
        }

        return mengenlehreuhrClock.getTime(hrs, mnts, scnds);

    }
}
