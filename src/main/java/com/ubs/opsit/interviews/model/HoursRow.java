package com.ubs.opsit.interviews.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class HoursRow implements LitRecalculableComposite {

    private final LitRecalculableComposite firstHoursRow;
    private final LitRecalculableComposite secondHoursRow;

    public HoursRow(LitRecalculableComposite firstHoursRow, LitRecalculableComposite secondHoursRow) {
        this.firstHoursRow = firstHoursRow;
        this.secondHoursRow = secondHoursRow;
    }

    @Override
    public List<ClockRow.LightType[]> recalculate(int timePart) {
        int itemsPerChunk = LitFactory.Lit.HOURS_FIRST.getTimeItemsPerChunk();
        int pure = (timePart / itemsPerChunk) * itemsPerChunk;
        int reminder = timePart - pure;
        return new ArrayList<ClockRow.LightType[]>(){{
            add(firstHoursRow.recalculate(pure).get(0));
            add(secondHoursRow.recalculate(reminder).get(0));
        }} ;
    }
}
