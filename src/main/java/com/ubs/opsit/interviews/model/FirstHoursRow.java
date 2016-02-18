package com.ubs.opsit.interviews.model;

import com.ubs.opsit.interviews.model.rprsntr.Representable;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
class FirstHoursRow extends ClockRow {
    public FirstHoursRow(int timeItemsPerChunk, int chunksCount, Representable<String> representable) {
        super(timeItemsPerChunk, chunksCount, representable);
    }

    @Override
    protected LightType getCurrentChunkColor(int time, int i) {
        return LightType.RED;
    }
}
