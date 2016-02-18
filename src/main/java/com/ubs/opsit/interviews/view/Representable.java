package com.ubs.opsit.interviews.view;

import com.ubs.opsit.interviews.model.ClockRow;

import java.util.List;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public interface Representable<T> {
    T represent(List<ClockRow.LightType[]> lightTypes);
}
