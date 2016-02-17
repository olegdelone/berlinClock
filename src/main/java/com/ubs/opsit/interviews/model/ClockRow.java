package com.ubs.opsit.interviews.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public abstract class ClockRow {
    private static final Logger LOG = LoggerFactory.getLogger(ClockRow.class);

    protected ClockRow() {
    }

    public enum LightType {
        RED, YELLOW, OFF;
        private String representationCode = this.name().substring(0,1); // R\Y\O

        public String getRepresentationCode() {
            return representationCode;
        }
    }

    protected abstract int getTimeItemsPerChunk();

    protected abstract int getChunksCount();

    protected abstract LightType getCurrentChunkColor(int time, int i);


    /**
     * factory method
     * @param type calendar type
     */
//    public ClockRow createRow(int type, int timePart){
//        ClockRow clockRow;
//        if(type == Calendar.HOUR_OF_DAY) {
//            clockRow = new FirstHoursRow();
//            clockRow.
////            int reminder = (timePart % clockRow.getTimeItemsPerChunk()) ;
////            clockRow.getChunks(timePart - reminder);
//        }
//    }
    /**
     *
     * @param timeItems prepared to show
     * @return
     */
    protected LightType[] getChunks(int timeItems) {
//        int cnt = timeItems/(getTimeItemsPerChunk() * getChunksCount());
//        if(cnt > 0){
//            timeItems -= cnt*getTimeItemsPerChunk() * getChunksCount();
//        }
//        LOG.info("time items: {} {}", timeItems, cnt);
//        if(timeItems)
        int filledLen = timeItems/getTimeItemsPerChunk();
        LightType[] r = new LightType[getChunksCount()];
        for (int i = 0, l = getChunksCount(); i < l;i++) {
            LightType type;
            if(i< filledLen) {
                type = getCurrentChunkColor(timeItems, i+1);
            } else {
                type = LightType.OFF;
            }
            r[i] = type;
        }

        return r;
    }


//    enum Lit {
//        SECONDS, HOURS_FIRST, HOURS_SECOND, MINUTES_FIRST, MINUTES_SECOND
//    }
}
