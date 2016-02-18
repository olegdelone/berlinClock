package com.ubs.opsit.interviews.model.clock;

import com.ubs.opsit.interviews.model.ClockRow;
import com.ubs.opsit.interviews.model.HoursRow;
import com.ubs.opsit.interviews.model.LightsComposite;
import com.ubs.opsit.interviews.model.MinutesRow;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class MengenlehreuhrClock {

    public enum Lit {
        SECONDS(1, 1), HOURS_FIRST(5, 4), HOURS_SECOND(1, 4), MINUTES_FIRST(5, 11), MINUTES_SECOND(1, 4);
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

    private final LightsComposite secs = ClockRow.createRow(MengenlehreuhrClock.Lit.SECONDS);
    private final LightsComposite hrsCmp = new HoursRow();
    private final LightsComposite minsCmp = new MinutesRow();

// not sure if there are another type of berlin type clocks - therefore there is no interface
    public String getTime(int hrs, int mnts, int scnds) {
        return secs.representSelf(scnds)
                + "\r\n" + hrsCmp.representSelf(hrs)
                + "\r\n" + minsCmp.representSelf(mnts);
    }


}
