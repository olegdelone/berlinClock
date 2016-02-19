package com.ubs.opsit.interviews.model;

/**
 * Created by olegdelone on 19.02.2016.
 */
public interface LitCalculable {
    int calculateChunks(int timePart);

    ClockRow.LightType[] getLights();
}
