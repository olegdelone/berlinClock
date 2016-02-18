package com.ubs.opsit.interviews.model;

import com.ubs.opsit.interviews.model.rprsntr.Representable;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
class SecondMinutesRow extends SecondHoursRow {

    public SecondMinutesRow(int timeItemsPerChunk, int chunksCount, Representable<String> representable) {
        super(timeItemsPerChunk, chunksCount, representable);
    }

    @Override
    protected LightType getCurrentChunkColor(int time, int i) {
        return LightType.YELLOW;
    }
}
