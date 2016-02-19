package com.ubs.opsit.interviews.model;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class ClockRow implements LitCalculable {

    public enum LightType {
        RED, YELLOW, OFF;
    }

    private final LightType[] lights;
    private final int timeItemsPerChunk;
    private final Colorer colorer;
    private final int chunksCount;

    ClockRow(int timeItemsPerChunk, int chunksCount, Colorer colorer) {
        // todo null checking
        this.timeItemsPerChunk = timeItemsPerChunk;
        this.chunksCount = chunksCount;
        this.colorer = colorer;
        this.lights = new LightType[chunksCount];
    }

    @Override
    public int calculateChunks(int timePart) {
        if (timePart < 0 ) {
            throw new IllegalArgumentException("arg [int timePart] violates condition [timePart < 0]");
        }
        int capacity = timeItemsPerChunk * chunksCount;
        int reminder = 0;
        if (timePart > capacity) {
            reminder = timePart - capacity;
            timePart = capacity;
        } else if (timeItemsPerChunk > 1) {
            int pure = (timePart / timeItemsPerChunk) * timeItemsPerChunk;
            reminder = timePart - pure;
            timePart = pure;
        }
        for (int i = 0, filledLen = timePart / timeItemsPerChunk; i < chunksCount; i++) {
            LightType type;
            if (i < filledLen) {
                type = colorer.doColoring(timePart, i + 1);
            } else {
                type = LightType.OFF;
            }
            lights[i] = type;
        }
        return reminder;
    }

    public LightType[] getLights() {
        return lights;
    }

    interface Colorer {
        LightType doColoring(int time, int step);
    }
}
