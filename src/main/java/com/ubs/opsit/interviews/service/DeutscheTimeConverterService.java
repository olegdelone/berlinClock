package com.ubs.opsit.interviews.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class DeutscheTimeConverterService implements TimeConverterService{

    @Override
    public String convertTime(String aTime) throws TimeConverterServiceException{
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm:ss"); // not thread safe

        Date date;
        try {
            date = parser.parse(aTime);
        } catch (ParseException e) {
            throw new TimeConverterServiceException(e);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hrs = calendar.get(Calendar.HOUR_OF_DAY);
        int mnts = calendar.get(Calendar.MINUTE);
        int scnds = calendar.get(Calendar.SECOND);

        return null;



    }
}
