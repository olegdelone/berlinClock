package com.ubs.opsit.interviews.model;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class ClockRowTest {
    private static final Logger LOG = LoggerFactory.getLogger(ClockRowTest.class);

    @Test
    public void testSecondsRow() {
        LOG.info("let's begin..");
        ClockRow clockRow = new SecondsRow();
        ClockRow.LightType[] lightTypes = clockRow.getChunks(1);
        Assert.assertArrayEquals(lightTypes, new ClockRow.LightType[] { ClockRow.LightType.YELLOW });

        lightTypes = clockRow.getChunks(2);
        Assert.assertArrayEquals(lightTypes, new ClockRow.LightType[] { ClockRow.LightType.OFF });

        lightTypes = clockRow.getChunks(10);
        Assert.assertArrayEquals(lightTypes, new ClockRow.LightType[] { ClockRow.LightType.OFF });

        lightTypes = clockRow.getChunks(100);
        Assert.assertArrayEquals(lightTypes, new ClockRow.LightType[] { ClockRow.LightType.OFF });

        lightTypes = clockRow.getChunks(101);
        Assert.assertArrayEquals(lightTypes, new ClockRow.LightType[] { ClockRow.LightType.YELLOW });

    }

    @Test
    public void testFirstHoursRow() {
        LOG.info("let's begin..");
        ClockRow clockRow = new FirstHoursRow();
        ClockRow.LightType[] offs = new ClockRow.LightType[] { ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF };

        ClockRow.LightType[] lightTypes = clockRow.getChunks(1);
        Assert.assertArrayEquals(lightTypes, offs);
        lightTypes = clockRow.getChunks(2);
        Assert.assertArrayEquals(lightTypes, offs);
        lightTypes = clockRow.getChunks(0);
        Assert.assertArrayEquals(lightTypes, offs);
        lightTypes = clockRow.getChunks(3);
        Assert.assertArrayEquals(lightTypes, offs);
        lightTypes = clockRow.getChunks(5);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.RED, ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF });
        lightTypes = clockRow.getChunks(11);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.OFF, ClockRow.LightType.OFF });
        lightTypes = clockRow.getChunks(23);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.RED });

        LOG.info("lightTypes: {}", Arrays.toString(lightTypes));

        lightTypes = clockRow.getChunks(105);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.RED });

    }

    @Test
    public void testSecondRow() {
        LOG.info("let's begin..");
        ClockRow clockRow = new SecondRow();
        ClockRow.LightType[] lightTypes = clockRow.getChunks(0);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF });

        lightTypes = clockRow.getChunks(1);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.RED, ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF });

        lightTypes = clockRow.getChunks(2);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.OFF, ClockRow.LightType.OFF });

        lightTypes = clockRow.getChunks(3);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.OFF });

        lightTypes = clockRow.getChunks(4);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.RED });

        lightTypes = clockRow.getChunks(105);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.RED });

    }

    @Test
    public void testFirstMinutesRow() {
        LOG.info("let's begin..");
        ClockRow clockRow = new FirstMinutesRow();
        ClockRow.LightType[] lightTypes = clockRow.getChunks(0);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                                            ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                                            ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                                            ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                });

        lightTypes = clockRow.getChunks(10);
        LOG.info("lightTypes: {}", Arrays.toString(lightTypes));
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.YELLOW, ClockRow.LightType.YELLOW, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                });

        lightTypes = clockRow.getChunks(16);
        LOG.info("lightTypes: {}", Arrays.toString(lightTypes));
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[]{ClockRow.LightType.YELLOW, ClockRow.LightType.YELLOW, ClockRow.LightType.RED,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                });


        lightTypes = clockRow.getChunks(51);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.YELLOW, ClockRow.LightType.YELLOW, ClockRow.LightType.RED,
                       ClockRow.LightType.YELLOW, ClockRow.LightType.YELLOW, ClockRow.LightType.RED,
                       ClockRow.LightType.YELLOW, ClockRow.LightType.YELLOW, ClockRow.LightType.RED,
                        ClockRow.LightType.YELLOW, ClockRow.LightType.OFF,
                });


    }
}
