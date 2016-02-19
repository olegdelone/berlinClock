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
        LitCalculable clockRow = LitFactory.createRow(LitFactory.Lit.SECONDS);
        clockRow.calculateChunks(1);
        ClockRow.LightType[] lightTypes = clockRow.getLights();
        Assert.assertArrayEquals(lightTypes, new ClockRow.LightType[]{ClockRow.LightType.OFF});

        clockRow.calculateChunks(2);
        lightTypes = clockRow.getLights();
        Assert.assertArrayEquals(lightTypes, new ClockRow.LightType[]{ClockRow.LightType.YELLOW});

        clockRow.calculateChunks(0);
        lightTypes = clockRow.getLights();
        Assert.assertArrayEquals(lightTypes, new ClockRow.LightType[]{ClockRow.LightType.YELLOW});

        clockRow.calculateChunks(10);
        lightTypes = clockRow.getLights();
        Assert.assertArrayEquals(lightTypes, new ClockRow.LightType[]{ClockRow.LightType.YELLOW});

        clockRow.calculateChunks(100);
        lightTypes = clockRow.getLights();
        Assert.assertArrayEquals(lightTypes, new ClockRow.LightType[]{ClockRow.LightType.YELLOW});

        clockRow.calculateChunks(101);
        lightTypes = clockRow.getLights();
        Assert.assertArrayEquals(lightTypes, new ClockRow.LightType[]{ClockRow.LightType.OFF});

    }

    @Test
    public void testFirstHoursRow() {
        LOG.info("let's begin..");
        LitCalculable clockRow = LitFactory.createRow(LitFactory.Lit.HOURS_FIRST);
        ClockRow.LightType[] offs = new ClockRow.LightType[]{ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF};

        clockRow.calculateChunks(1);
        ClockRow.LightType[]  lightTypes = clockRow.getLights();
        Assert.assertArrayEquals(lightTypes, offs);
        clockRow.calculateChunks(2);
        lightTypes = clockRow.getLights();
        Assert.assertArrayEquals(lightTypes, offs);
        clockRow.calculateChunks(0);
        lightTypes = clockRow.getLights();
        Assert.assertArrayEquals(lightTypes, offs);
        clockRow.calculateChunks(3);
        lightTypes = clockRow.getLights();

        Assert.assertArrayEquals(lightTypes, offs);
        clockRow.calculateChunks(5);
        lightTypes = clockRow.getLights();

        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[]{ClockRow.LightType.RED, ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF});
        clockRow.calculateChunks(11);
        lightTypes = clockRow.getLights();

        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[]{ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.OFF, ClockRow.LightType.OFF});


    }

    @Test
    public void testSecondHoursRow() {
        LOG.info("let's begin..");
        LitCalculable clockRow = LitFactory.createRow(LitFactory.Lit.HOURS_SECOND);


        clockRow.calculateChunks(0);
        ClockRow.LightType[] lightTypes = clockRow.getLights();
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[]{ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF});

        clockRow.calculateChunks(1);
        lightTypes = clockRow.getLights();

        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[]{ClockRow.LightType.RED, ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF});

        clockRow.calculateChunks(2);
        lightTypes = clockRow.getLights();

        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[]{ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.OFF, ClockRow.LightType.OFF});

        clockRow.calculateChunks(3);
        lightTypes = clockRow.getLights();

        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[]{ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.OFF});

        clockRow.calculateChunks(4);
        lightTypes = clockRow.getLights();

        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[]{ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.RED, ClockRow.LightType.RED});


    }

    @Test
    public void testFirstMinutesRow() {
        LOG.info("let's begin..");
        LitCalculable clockRow = LitFactory.createRow(LitFactory.Lit.MINUTES_FIRST);

        clockRow.calculateChunks(0);
        ClockRow.LightType[] lightTypes = clockRow.getLights();

        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[]{ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                });

        clockRow.calculateChunks(10);
        lightTypes = clockRow.getLights();

        LOG.info("lightTypes: {}", Arrays.toString(lightTypes));
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[]{ClockRow.LightType.YELLOW, ClockRow.LightType.YELLOW, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                });


        clockRow.calculateChunks(16);
        lightTypes = clockRow.getLights();

        LOG.info("lightTypes: {}", Arrays.toString(lightTypes));
        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[]{ClockRow.LightType.YELLOW, ClockRow.LightType.YELLOW, ClockRow.LightType.RED,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                        ClockRow.LightType.OFF, ClockRow.LightType.OFF,
                });


        clockRow.calculateChunks(51);
        lightTypes = clockRow.getLights();

        Assert.assertArrayEquals(lightTypes,
                new ClockRow.LightType[]{ClockRow.LightType.YELLOW, ClockRow.LightType.YELLOW, ClockRow.LightType.RED,
                        ClockRow.LightType.YELLOW, ClockRow.LightType.YELLOW, ClockRow.LightType.RED,
                        ClockRow.LightType.YELLOW, ClockRow.LightType.YELLOW, ClockRow.LightType.RED,
                        ClockRow.LightType.YELLOW, ClockRow.LightType.OFF,
                });


    }
}
