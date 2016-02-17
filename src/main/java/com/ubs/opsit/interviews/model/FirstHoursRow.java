package com.ubs.opsit.interviews.model;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class FirstHoursRow extends ClockRow {

    @Override
    protected int getTimeItemsPerChunk() {
        return 5;
    }

    @Override
    protected int getChunksCount() {
        return 4;
    }

    @Override
    protected LightType getCurrentChunkColor(int time, int i) {
        return LightType.RED;
    }
}
