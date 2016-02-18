package com.ubs.opsit.interviews.model.clock;

import com.ubs.opsit.interviews.model.*;
import com.ubs.opsit.interviews.view.Representable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class BerlinClock extends ClockWithRows {

    private final LitRecalculableComposite secs = LitFactory.createComposite(Calendar.SECOND);
    private final LitRecalculableComposite hrsCmp = LitFactory.createComposite(Calendar.HOUR_OF_DAY);
    private final LitRecalculableComposite minsCmp = LitFactory.createComposite(Calendar.MINUTE);

    public BerlinClock(Representable<String> representable) {
        super(representable);
    }


    @Override
    protected List<ClockRow.LightType[]> recalcRows(int hrs, int mnts, int scnds) {
        List<ClockRow.LightType[]> result = new ArrayList<>(5); // order is important
        result.addAll(secs.recalculate(scnds));
        result.addAll(hrsCmp.recalculate(hrs));
        result.addAll(minsCmp.recalculate(mnts));
        return result;
    }
}
