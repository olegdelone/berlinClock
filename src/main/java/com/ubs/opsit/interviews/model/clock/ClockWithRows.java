package com.ubs.opsit.interviews.model.clock;

import com.ubs.opsit.interviews.model.ClockRow;
import com.ubs.opsit.interviews.view.Representable;

/**
 * Created by Oleg_Obukhov on 18.02.2016.
 */
public abstract class ClockWithRows implements Iterable<ClockRow.LightType[]> {
    private final Representable<String, ClockRow.LightType[]> representable; // bridge

    protected ClockWithRows(Representable<String, ClockRow.LightType[]> representable) {
        this.representable = representable;
    }

    public String getTime(int hrs, int mnts, int scnds) {
        recalcRows(hrs, mnts, scnds);
        return representable.represent(this);
    }

    protected abstract void recalcRows(int hrs, int mnts, int scnds);
}
