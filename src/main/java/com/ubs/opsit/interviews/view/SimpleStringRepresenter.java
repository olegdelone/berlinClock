package com.ubs.opsit.interviews.view;

import com.ubs.opsit.interviews.model.ClockRow;

import java.util.List;

/**
 * Created by Oleg_Obukhov on 17.02.2016.
 */
public class SimpleStringRepresenter implements Representable<String> {

    @Override
    public String represent(List<ClockRow.LightType[]> lightTypesList) {
        StringBuilder r = new StringBuilder();
        for (int i = 0, s = lightTypesList.size(); i < s; i++) {
            for (ClockRow.LightType lightType : lightTypesList.get(i)) {
                r.append(lightType.name().substring(0, 1)); // R Y O
            }
            if(i != s-1){
                r.append("\r\n");
            }
        }
        return r.toString();
    }
}
