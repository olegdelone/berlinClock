package com.ubs.opsit.interviews.model.rprsntr;

import com.ubs.opsit.interviews.model.ClockRow;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public interface Representable<T> {
    T represent(ClockRow.LightType[] lightTypes);
}
