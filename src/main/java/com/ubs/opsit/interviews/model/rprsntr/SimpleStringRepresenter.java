package com.ubs.opsit.interviews.model.rprsntr;

import com.ubs.opsit.interviews.model.ClockRow;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class SimpleStringRepresenter implements Representable<String> {

    @Override
    public String represent(ClockRow.LightType[] lightTypes) {
        String r = "";
        for (ClockRow.LightType lightType : lightTypes) {
            r+=lightType.getRepresentationCode();
        }
        return r;
    }
}
