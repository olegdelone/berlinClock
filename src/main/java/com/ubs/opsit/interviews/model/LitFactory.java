package com.ubs.opsit.interviews.model;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * Created by Oleg_Obukhov on 18.02.2016.
 */
public class LitFactory {

    public enum Lit {
        HOURS_FIRST(5, 4), HOURS_SECOND(1, 4), MINUTES_FIRST(5, 11), MINUTES_SECOND(1, 4);
        private final int timeItemsPerChunk;
        private final int chunksCount;

        Lit(int timeItemsPerChunk, int chunksCount) {
            this.timeItemsPerChunk = timeItemsPerChunk;
            this.chunksCount = chunksCount;
        }

        public int getTimeItemsPerChunk() {
            return timeItemsPerChunk;
        }

        public int getChunksCount() {
            return chunksCount;
        }
    }

    public static ClockRow createRow(Lit type) {
            ClockRow clockRow;
            if (type == Lit.HOURS_FIRST) {
                clockRow = new FirstHoursRow(type.getTimeItemsPerChunk(), type.getChunksCount());
            } else if (type == Lit.HOURS_SECOND) {
                clockRow = new SecondHoursRow(type.getTimeItemsPerChunk(), type.getChunksCount());
            } else if (type == Lit.MINUTES_SECOND) {
                clockRow = new SecondMinutesRow(type.getTimeItemsPerChunk(), type.getChunksCount());
            } else if (type == Lit.MINUTES_FIRST) {
                clockRow = new FirstMinutesRow(type.getTimeItemsPerChunk(), type.getChunksCount());
            } else {
                throw new IllegalArgumentException("Such arg [Lit type] is not supported: " + type);
            }
            return clockRow;
    }

    public static LitRecalculableComposite createComposite(int calendarType) {
        if (calendarType == Calendar.HOUR_OF_DAY) {
            LitRecalculableComposite composite1 = createRow(Lit.HOURS_FIRST);
            LitRecalculableComposite composite2 = createRow(Lit.HOURS_SECOND);
            return new HoursRow(composite1, composite2);
        } else if (calendarType == Calendar.MINUTE) {
            LitRecalculableComposite composite1 = createRow(Lit.MINUTES_FIRST);
            LitRecalculableComposite composite2 = createRow(Lit.MINUTES_SECOND);
            return new MinutesRow(composite1, composite2);
        } else if (calendarType == Calendar.SECOND){
            return time -> {
                ClockRow.LightType lightType = (time & 1) != 0 ? ClockRow.LightType.OFF : ClockRow.LightType.YELLOW;
                return Collections.singletonList(new ClockRow.LightType[]{lightType});
            };
        } else {
            throw new IllegalArgumentException("Such arg [int calendarType] = " + calendarType + " is not supperted");
        }
    }
}
