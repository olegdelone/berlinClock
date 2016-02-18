package com.ubs.opsit.interviews.model;

import com.ubs.opsit.interviews.model.clock.MengenlehreuhrClock;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class HoursRow implements LightsComposite {

    private final LightsComposite firstHoursRow;
    private final LightsComposite secondHoursRow;

    public HoursRow() {
        this.firstHoursRow = ClockRow.createRow(MengenlehreuhrClock.Lit.HOURS_FIRST);
        this.secondHoursRow = ClockRow.createRow(MengenlehreuhrClock.Lit.HOURS_SECOND);
    }

    @Override
    public String representSelf(int timePart) {
        int itemsPerChunk = MengenlehreuhrClock.Lit.HOURS_FIRST.getTimeItemsPerChunk();
        int pure = (timePart / itemsPerChunk) * itemsPerChunk;
        int reminder = timePart - pure;
        return firstHoursRow.representSelf(pure) + "\r\n" + secondHoursRow.representSelf(reminder);
    }
}
