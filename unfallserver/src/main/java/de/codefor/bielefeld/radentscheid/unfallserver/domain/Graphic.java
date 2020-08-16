package de.codefor.bielefeld.radentscheid.unfallserver.domain;

import java.util.Arrays;
import java.util.Objects;

/**
 * author skonair@gmail.com
 * date 16.08.20
 */
public class Graphic {

    private final String format;
    private final byte[] content;

    public Graphic(String format, byte[] content) {
        this.format = format;
        this.content = content;
    }

    String format() {
        return format;
    }

    byte[] content() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graphic grafik = (Graphic) o;
        return Objects.equals(format, grafik.format) &&
                Arrays.equals(content, grafik.content);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(format);
        result = 31 * result + Arrays.hashCode(content);
        return result;
    }
}
