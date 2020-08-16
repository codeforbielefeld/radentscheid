package de.codefor.bielefeld.radentscheid.unfallserver.adapter.json;

import java.util.List;

/**
 * author skonair@gmail.com
 * date 16.08.20
 */
public class KindsDto {

    private List<KindDto> kinds;

    public List<KindDto> getKinds() {
        return kinds;
    }

    public void setKinds(List<KindDto> kinds) {
        this.kinds = kinds;
    }
}
