package com.ubs.opsit.interviews.model;

import java.util.Collections;
import java.util.List;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public abstract class ClockRow implements LitRecalculableComposite {

    public enum LightType {
        RED, YELLOW, OFF;
    }

    private final int timeItemsPerChunk;
    private final int chunksCount;

    protected ClockRow(int timeItemsPerChunk, int chunksCount) {
        this.timeItemsPerChunk = timeItemsPerChunk;
        this.chunksCount = chunksCount;
    }

    protected abstract LightType getCurrentChunkColor(int time, int i);

    public List<LightType[]> recalculate(int timePart) {
        return Collections.singletonList(calculateChunks(timePart));
    }

    protected LightType[] calculateChunks(int timePart) {
        int capacity = timeItemsPerChunk * chunksCount;
        if (timePart < 0 || timePart > capacity) {
            throw new IllegalArgumentException("arg violated [timePart < 0 || timePart > " + capacity + "]");
        }
        int toBeFilledLen = timePart / timeItemsPerChunk;
        LightType[] r = new LightType[chunksCount];
        for (int i = 0; i < chunksCount; i++) {
            LightType type;
            if (i < toBeFilledLen) {
                type = getCurrentChunkColor(timePart, i + 1);
            } else {
                type = LightType.OFF;
            }
            r[i] = type;
        }
        return r;
    }

}
