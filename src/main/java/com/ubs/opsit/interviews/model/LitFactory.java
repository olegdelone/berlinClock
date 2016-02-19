package com.ubs.opsit.interviews.model;

/**
 * Created by Oleg_Obukhov on 18.02.2016.
 */
public class LitFactory {

    public enum Lit {
        HOURS_FIRST(5, 4), HOURS_SECOND(1, 4), MINUTES_FIRST(5, 11), MINUTES_SECOND(1, 4), SECONDS(1, 1);
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

    public static LitCalculable createRow(Lit type) {
        ClockRow clockRow;
        if (type == Lit.HOURS_FIRST) {
            clockRow = new ClockRow(type.getTimeItemsPerChunk(), type.getChunksCount(),
                                    (time, step) -> ClockRow.LightType.RED);

        } else if (type == Lit.HOURS_SECOND) {
            clockRow = new ClockRow(type.getTimeItemsPerChunk(), type.getChunksCount(),
                                    (time, step) -> ClockRow.LightType.RED);

        } else if (type == Lit.MINUTES_SECOND) {
            clockRow = new ClockRow(type.getTimeItemsPerChunk(), type.getChunksCount(),
                                    (time, step) -> ClockRow.LightType.YELLOW);

        } else if (type == Lit.MINUTES_FIRST) {
            clockRow = new ClockRow(type.getTimeItemsPerChunk(), type.getChunksCount(),
                                    (time, step) -> step % 3 == 0 ? ClockRow.LightType.RED : ClockRow.LightType.YELLOW);

        } else if (type == Lit.SECONDS) {
            return new LitCalculable() {
                private final ClockRow.LightType[] l = new ClockRow.LightType[1];
                @Override
                public int calculateChunks(int time) {
                    l[0] = (time & 1) != 0 ? ClockRow.LightType.OFF : ClockRow.LightType.YELLOW;
                    return --time;
                }

                @Override
                public ClockRow.LightType[] getLights() {
                    return l;
                }
            };
        } else {
            throw new IllegalArgumentException("Such arg [Lit type] is not supported: " + type);
        }
        return clockRow;
    }

}
