package com.ubs.opsit.interviews.model;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class FirstMinutesRow extends ClockRow{
    @Override
    protected int getTimeItemsPerChunk() {
        return 5;
    }

    @Override
    protected int getChunksCount() {
        return 11;
    }

    @Override
    protected LightType getCurrentChunkColor(int time, int i) {
        return i%3 == 0  ? LightType.RED : LightType.YELLOW;
    }
}
