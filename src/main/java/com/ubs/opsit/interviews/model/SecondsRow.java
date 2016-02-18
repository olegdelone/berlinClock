package com.ubs.opsit.interviews.model;

import com.ubs.opsit.interviews.model.rprsntr.Representable;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
class SecondsRow extends ClockRow {
    public SecondsRow(int timeItemsPerChunk, int chunksCount, Representable<String> representable) {
        super(timeItemsPerChunk, chunksCount, representable);
    }

    @Override
    protected LightType getCurrentChunkColor(int time, int i) {
        return (time & 1) != 0 ? LightType.OFF : LightType.YELLOW;
    }

    @Override
    public LightType[] calculateChunks(int timePart) {
        return new LightType[] { getCurrentChunkColor(timePart, 0) };
    }
}
