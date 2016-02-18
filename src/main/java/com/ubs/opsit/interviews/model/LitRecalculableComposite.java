package com.ubs.opsit.interviews.model;

import java.util.List;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public interface LitRecalculableComposite {
    List<ClockRow.LightType[]> recalculate(int timePart);
}
