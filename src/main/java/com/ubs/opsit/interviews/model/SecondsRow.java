package com.ubs.opsit.interviews.model;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class SecondsRow extends ClockRow {

    @Override
    protected int getTimeItemsPerChunk() {
        return 1;
    }

    @Override
    protected int getChunksCount() {
        return 1;
    }

    @Override
    protected LightType getCurrentChunkColor(int time, int i) {
        return (time & 1) == 0 ? LightType.OFF : LightType.YELLOW;
    }
}
