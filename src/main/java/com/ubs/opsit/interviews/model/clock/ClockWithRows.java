package com.ubs.opsit.interviews.model.clock;

import com.ubs.opsit.interviews.model.ClockRow;
import com.ubs.opsit.interviews.view.Representable;

import java.util.List;

/**
 * Created by Oleg_Obukhov on 18.02.2016.
 */
public abstract class ClockWithRows {
    private final Representable<String> representable; // bridge

    protected ClockWithRows(Representable<String> representable) {
        this.representable = representable;
    }

    public String getTime(int hrs, int mnts, int scnds) {
        return representable.represent(recalcRows(hrs, mnts, scnds));
    }

    /**
     * not thread safe!
     */
    protected abstract List<ClockRow.LightType[]> recalcRows(int hrs, int mnts, int scnds);
}
