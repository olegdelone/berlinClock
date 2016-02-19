package com.ubs.opsit.interviews.view;

import com.ubs.opsit.interviews.model.ClockRow;

import java.util.Iterator;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class SimpleStringRepresenter implements Representable<String, ClockRow.LightType[]> {

    @Override
    public String represent(Iterable<ClockRow.LightType[]> iterable) {
        StringBuilder r = new StringBuilder();
        Iterator<ClockRow.LightType[]> iterator = iterable.iterator();

        while (iterator.hasNext()){
            for (ClockRow.LightType lightType : iterator.next()) {
                r.append(lightType.name().substring(0, 1)); // R Y O
            }
            if(iterator.hasNext()){
                r.append("\r\n");
            }
        }
        return r.toString();

    }
}
