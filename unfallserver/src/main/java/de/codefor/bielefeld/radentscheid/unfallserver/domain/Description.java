package de.codefor.bielefeld.radentscheid.unfallserver.domain;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * A generic description object that consists of the three layers:
 * <ul>
 *     <li>Introduction</li>
 *     <li>List of graphics</li>
 *     <li>Text</li>
 * </ul>
 * author skonair@gmail.com
 * date 16.08.20
 */
public class Description {

    private final String introduction;
    private final List<Graphic> graphics;
    private final Optional<String> text;

    public Description(String introduction, List<Graphic> graphics, Optional<String> text) {
        this.introduction = introduction;
        this.graphics = graphics;
        this.text = text;
    }

    public String introduction() {
        return introduction;
    }

    public List<Graphic> graphics() {
        return graphics;
    }

    public String text() {
        return text.orElse("");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(introduction, that.introduction) &&
                Objects.equals(graphics, that.graphics) &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(introduction, graphics, text);
    }
}
