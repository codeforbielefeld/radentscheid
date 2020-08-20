package de.codefor.bielefeld.radentscheid.unfallserver.domain;

import java.util.Objects;

/**
 * author skonair@gmail.com
 * date 16.08.20
 */
public class Kind {

    private final int id;
    private final Description description;

    public Kind(int id, Description description) {
        this.id = id;
        this.description = description;
    }

    public int id() {
        return id;
    }

    Description description() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kind kind = (Kind) o;
        return id == kind.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
