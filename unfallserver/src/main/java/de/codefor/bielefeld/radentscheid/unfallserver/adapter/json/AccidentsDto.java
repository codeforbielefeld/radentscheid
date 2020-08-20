package de.codefor.bielefeld.radentscheid.unfallserver.adapter.json;

import java.util.List;

/**
 * author skonair@gmail.com
 * date 16.08.20
 */
public class AccidentsDto {

    private List<AccidentDto> accidents;

    public List<AccidentDto> getAccidents() {
        return accidents;
    }

    public void setAccidents(List<AccidentDto> accidents) {
        this.accidents = accidents;
    }
}
