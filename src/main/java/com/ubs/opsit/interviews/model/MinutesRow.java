package com.ubs.opsit.interviews.model;

import com.ubs.opsit.interviews.model.clock.MengenlehreuhrClock;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class MinutesRow implements LightsComposite {

    private final LightsComposite firstMinsRow;
    private final LightsComposite secondMinsRow;

    public MinutesRow() {
        this.firstMinsRow = ClockRow.createRow(MengenlehreuhrClock.Lit.MINUTES_FIRST);
        this.secondMinsRow = ClockRow.createRow(MengenlehreuhrClock.Lit.MINUTES_SECOND);
    }

    @Override
    public String representSelf(int timePart) {
        int itemsPerChunk = MengenlehreuhrClock.Lit.MINUTES_FIRST.getTimeItemsPerChunk();
        int pure = (timePart / itemsPerChunk) * itemsPerChunk;
        int reminder = timePart - pure;
        return firstMinsRow.representSelf(pure) + "\r\n" + secondMinsRow.representSelf(reminder);
    }
}
