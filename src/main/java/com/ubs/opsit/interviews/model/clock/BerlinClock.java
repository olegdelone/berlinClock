package com.ubs.opsit.interviews.model.clock;

import com.ubs.opsit.interviews.model.ClockRow;
import com.ubs.opsit.interviews.model.LitCalculable;
import com.ubs.opsit.interviews.model.LitFactory;
import com.ubs.opsit.interviews.view.Representable;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class BerlinClock extends ClockWithRows {

    private int mod;
    private final LitCalculable secs = LitFactory.createRow(LitFactory.Lit.SECONDS);
    private final LitCalculable hrsFirst = LitFactory.createRow(LitFactory.Lit.HOURS_FIRST);
    private final LitCalculable hrsSecond = LitFactory.createRow(LitFactory.Lit.HOURS_SECOND);
    private final LitCalculable minsFirst = LitFactory.createRow(LitFactory.Lit.MINUTES_FIRST);
    private final LitCalculable minsSecond = LitFactory.createRow(LitFactory.Lit.MINUTES_SECOND);

    public BerlinClock(Representable<String, ClockRow.LightType[]> representable) {
        super(representable);
    }

    @Override
    protected void recalcRows(int hrs, int mnts, int scnds) {
        mod++;
        secs.calculateChunks(scnds);
        int reminder = hrsFirst.calculateChunks(hrs);
        hrsSecond.calculateChunks(reminder);

        reminder = minsFirst.calculateChunks(mnts);
        minsSecond.calculateChunks(reminder);
    }

    @Override
    public Iterator<ClockRow.LightType[]> iterator() {
        return new Iterator<ClockRow.LightType[]>() {
            int modSnapshot = mod;
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < 5;
            }

            @Override
            public ClockRow.LightType[] next() {
                if (modSnapshot != mod) { // fast fail
                    throw new ConcurrentModificationException();
                }
                ClockRow.LightType[] result;
                if (i == 0) {
                    result = secs.getLights();
                } else if (i == 1) {
                    result = hrsFirst.getLights();
                } else if (i == 2) {
                    result = hrsSecond.getLights();
                } else if (i == 3) {
                    result = minsFirst.getLights();
                } else if (i == 4) {
                    result = minsSecond.getLights();
                } else {
                    throw new ArrayIndexOutOfBoundsException("use hasNext() in order to avoid this situation");
                }
                i++;
                return result;
            }
        };
    }


}
