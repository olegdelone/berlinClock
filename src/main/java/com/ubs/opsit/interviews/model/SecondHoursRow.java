package com.ubs.opsit.interviews.model;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
class SecondHoursRow extends ClockRow {
    public SecondHoursRow(int timeItemsPerChunk, int chunksCount) {
        super(timeItemsPerChunk, chunksCount);
    }

    @Override
    protected LightType getCurrentChunkColor(int time, int i) {
        return LightType.RED;
    }
}
