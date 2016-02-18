package com.ubs.opsit.interviews.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class MinutesRow implements LitRecalculableComposite {

    private final LitRecalculableComposite firstMinsRow;
    private final LitRecalculableComposite secondMinsRow;

    public MinutesRow(LitRecalculableComposite firstMinsRow, LitRecalculableComposite secondMinsRow) {
        this.firstMinsRow = firstMinsRow;
        this.secondMinsRow = secondMinsRow;
    }

    @Override
    public List<ClockRow.LightType[]> recalculate(int timePart) {
        int itemsPerChunk = LitFactory.Lit.MINUTES_FIRST.getTimeItemsPerChunk();
        int pure = (timePart / itemsPerChunk) * itemsPerChunk;
        int reminder = timePart - pure;
        return new ArrayList<ClockRow.LightType[]>(){{
            add(firstMinsRow.recalculate(pure).get(0));
            add(secondMinsRow.recalculate(reminder).get(0));
        }} ;
    }
}
