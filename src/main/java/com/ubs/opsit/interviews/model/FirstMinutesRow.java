package com.ubs.opsit.interviews.model;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
class FirstMinutesRow extends ClockRow{
    public FirstMinutesRow(int timeItemsPerChunk, int chunksCount) {
        super(timeItemsPerChunk, chunksCount);
    }

    @Override
    protected LightType getCurrentChunkColor(int time, int i) {
        return i%3 == 0  ? LightType.RED : LightType.YELLOW;
    }
}
