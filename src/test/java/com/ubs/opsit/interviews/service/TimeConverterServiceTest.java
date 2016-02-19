package com.ubs.opsit.interviews.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class TimeConverterServiceTest {
    private static final Logger LOG = LoggerFactory.getLogger(TimeConverterServiceTest.class);

    TimeConverterService timeConverterService = new DeutscheTimeConverterService();

    @Test
    public void test() throws TimeConverterServiceException {
        String r = timeConverterService.convertTime("13:17:01");
        LOG.info("r=[{}]", r);
        // todo
    }
}
