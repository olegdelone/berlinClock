package com.ubs.opsit.interviews.model;

import com.ubs.opsit.interviews.model.clock.MengenlehreuhrClock;
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
        ClockRow clockRow = ClockRow.createRow(MengenlehreuhrClock.Lit.SECONDS);
        ClockRow.LightType[] lightTypes = clockRow.calculateChunks(1);
        Assert.assertArrayEquals(lightTypes, new ClockRow.LightType[] { ClockRow.LightType.OFF });

        lightTypes = clockRow.calculateChunks(2);
        Assert.assertArrayEquals(lightTypes, new ClockRow.LightType[] { ClockRow.LightType.YELLOW });

        lightTypes = clockRow.calculateChunks(0);
        Assert.assertArrayEquals(lightTypes, new ClockRow.LightType[] { ClockRow.LightType.YELLOW });

        lightTypes = clockRow.calculateChunks(10);
        Assert.assertArrayEquals(lightTypes, new ClockRow.LightType[] { ClockRow.LightType.YELLOW });

        lightTypes = clockRow.calculateChunks(100);
        Assert.assertArrayEquals(lightTypes, new ClockRow.LightType[] { ClockRow.LightType.YELLOW });

        lightTypes = clockRow.calculateChunks(101);
        Assert.assertArrayEquals(lightTypes, new ClockRow.LightType[] { ClockRow.LightType.OFF });

    }

    @Test
    public void testFirstHoursRow() {
        LOG.info("let's begin..");
        ClockRow clockRow = ClockRow.createRow(MengenlehreuhrClock.Lit.HOURS_FIRST);
        ClockRow.LightType[] offs = new ClockRow.LightType[] { ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF };

        ClockRow.LightType[] lightTypes = clockRow.calculateChunks(1);
        Assert.assertArrayEquals(lightTypes, offs);
        lightTypes = clockRow.calculateChunks(2);
        Assert.assertArrayEquals(lightTypes, offs);
        lightTypes = clockRow.calculateChunks(0);
        Assert.assertArrayEquals(lightTypes, offs);
        lightTypes = clockRow.calculateChunks(3);
        Assert.assertArrayEquals(lightTypes, offs);
        lightTypes = clockRow.calculateChunks(5);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.RED, ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF });
        lightTypes = clockRow.calculateChunks(11);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.OFF, ClockRow.LightType.OFF });


    }

    @Test
    public void testSecondHoursRow() {
        LOG.info("let's begin..");
        ClockRow clockRow = ClockRow.createRow(MengenlehreuhrClock.Lit.HOURS_SECOND);
        ClockRow.LightType[] lightTypes = clockRow.calculateChunks(0);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF });

        lightTypes = clockRow.calculateChunks(1);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.RED, ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF });

        lightTypes = clockRow.calculateChunks(2);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.OFF, ClockRow.LightType.OFF });

        lightTypes = clockRow.calculateChunks(3);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.OFF });

        lightTypes = clockRow.calculateChunks(4);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.RED });


    }

    @Test
    public void testFirstMinutesRow() {
        LOG.info("let's begin..");
        ClockRow clockRow = ClockRow.createRow(MengenlehreuhrClock.Lit.MINUTES_FIRST);
        ClockRow.LightType[] lightTypes = clockRow.calculateChunks(0);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[]{ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                });

        lightTypes = clockRow.calculateChunks(10);
        LOG.info("lightTypes: {}", Arrays.toString(lightTypes));
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.YELLOW, ClockRow.LightType.YELLOW, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                });

        lightTypes = clockRow.calculateChunks(16);
        LOG.info("lightTypes: {}", Arrays.toString(lightTypes));
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[]{ClockRow.LightType.YELLOW, ClockRow.LightType.YELLOW, ClockRow.LightType.RED,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                });


        lightTypes = clockRow.calculateChunks(51);
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[] { ClockRow.LightType.YELLOW, ClockRow.LightType.YELLOW, ClockRow.LightType.RED,
                       ClockRow.LightType.YELLOW, ClockRow.LightType.YELLOW, ClockRow.LightType.RED,
                       ClockRow.LightType.YELLOW, ClockRow.LightType.YELLOW, ClockRow.LightType.RED,
                        ClockRow.LightType.YELLOW, ClockRow.LightType.OFF,
                });


    }
}
