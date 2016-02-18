package com.ubs.opsit.interviews.model;

import com.ubs.opsit.interviews.model.clock.MengenlehreuhrClock;
import com.ubs.opsit.interviews.model.rprsntr.Representable;
import com.ubs.opsit.interviews.model.rprsntr.SimpleStringRepresenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public abstract class ClockRow implements LightsComposite {
    private static final Logger LOG = LoggerFactory.getLogger(ClockRow.class);

    private final int timeItemsPerChunk;
    private final int chunksCount;

    protected final Representable<String> representable; // bridge

    protected ClockRow(int timeItemsPerChunk, int chunksCount, Representable<String> representable) {
        this.timeItemsPerChunk = timeItemsPerChunk;
        this.chunksCount = chunksCount;
        this.representable = representable;
    }

    public enum LightType {
        RED, YELLOW, OFF;

        private String representationCode = this.name().substring(0, 1); // R\Y\O

        public String getRepresentationCode() {
            return representationCode;
        }

    }

    protected abstract LightType getCurrentChunkColor(int time, int i);

    /**
     * factory method
     *
     * @param type
     *            to be created
     */
    public static ClockRow createRow(MengenlehreuhrClock.Lit type) {
        ClockRow clockRow;
        Representable<String> representable = new SimpleStringRepresenter(); // todo
        if (type == MengenlehreuhrClock.Lit.HOURS_FIRST) {
            clockRow = new FirstHoursRow(type.getTimeItemsPerChunk(), type.getChunksCount(), representable);
        } else if (type == MengenlehreuhrClock.Lit.HOURS_SECOND) {
            clockRow = new SecondHoursRow(type.getTimeItemsPerChunk(), type.getChunksCount(), representable);
        } else if (type == MengenlehreuhrClock.Lit.MINUTES_SECOND) {
            clockRow = new SecondMinutesRow(type.getTimeItemsPerChunk(), type.getChunksCount(), representable);
        } else if (type == MengenlehreuhrClock.Lit.MINUTES_FIRST) {
            clockRow = new FirstMinutesRow(type.getTimeItemsPerChunk(), type.getChunksCount(), representable);
        } else if (type == MengenlehreuhrClock.Lit.SECONDS) {
            clockRow = new SecondsRow(type.getTimeItemsPerChunk(), type.getChunksCount(), representable);
        } else {
            throw new IllegalArgumentException("Arg [Lit type] is not supported: " + type);
        }
        return clockRow;
    }

    public String representSelf(int timePart) {
        return representable.represent(calculateChunks(timePart));
    }

    protected LightType[] calculateChunks(int timePart) {
        int capacity = timeItemsPerChunk * chunksCount;
        if (timePart < 0 || timePart > capacity) {
            throw new IllegalArgumentException("arg violated [timePart < 0 || timePart > "+capacity+"]");
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

    public int getTimeItemsPerChunk() {
        return timeItemsPerChunk;
    }
}
